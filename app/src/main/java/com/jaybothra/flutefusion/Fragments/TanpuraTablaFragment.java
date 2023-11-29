package com.jaybothra.flutefusion.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.media.MediaPlayer;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.jaybothra.flutefusion.R;

import java.util.Locale;


public class TanpuraTablaFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {
    private MediaPlayer mediaPlayer;
    private ImageButton btnPlay, btnPause;
    private SeekBar seekBar;
    private boolean isSeeking = false;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Handler handler;
    private TextView timeRemainingTextView;



    public TanpuraTablaFragment() {
        // Required empty public constructor
    }

    public static TanpuraTablaFragment newInstance(String param1, String param2) {
        TanpuraTablaFragment fragment = new TanpuraTablaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tanpura_tabla, container, false);

        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.tanpura_a);

        seekBar = view.findViewById(R.id.seekBar);
        btnPlay = view.findViewById(R.id.btnPlay);
        btnPause = view.findViewById(R.id.btnPause);
        timeRemainingTextView = view.findViewById(R.id.timeline);
        seekBar.setOnSeekBarChangeListener(this);
        handler = new Handler();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    btnPlay.setVisibility(View.GONE);
                    btnPause.setVisibility(View.VISIBLE);
                    startSeekBarUpdate(); // Start updating SeekBar when audio starts
                }
            }
        });


        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    btnPlay.setVisibility(View.VISIBLE);
                    btnPause.setVisibility(View.GONE);
                }
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // When audio playback is completed, reset UI
                btnPlay.setVisibility(View.VISIBLE);
                btnPause.setVisibility(View.GONE);
            }
        });

        if (mediaPlayer != null) {
            int totalDuration = mediaPlayer.getDuration();
            int totalMinutes = (totalDuration / 1000) / 60;
            int totalSeconds = (totalDuration / 1000) % 60;
            String totalDurationStr = String.format(Locale.getDefault(), "%02d:%02d", totalMinutes, totalSeconds);
            timeRemainingTextView.setText(totalDurationStr);
        }

        return view;
    }
    private void startSeekBarUpdate() {
        if (mediaPlayer != null) {
            seekBar.setMax(mediaPlayer.getDuration());

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                        int currentPosition = mediaPlayer.getCurrentPosition();
                        int totalDuration = mediaPlayer.getDuration();

                        // Calculate time remaining in milliseconds
                        int timeRemaining = totalDuration - currentPosition;

                        // Convert milliseconds to minutes and seconds
                        int minutes = (timeRemaining / 1000) / 60;
                        int seconds = (timeRemaining / 1000) % 60;

                        // Format the time remaining string
                        String timeRemainingStr = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

                        // Update the TextView with the time remaining
                        timeRemainingTextView.setText(timeRemainingStr);

                        // Update SeekBar progress
                        seekBar.setProgress(currentPosition);
                    }else {
                        // If music is not playing, show the total audio length
                        int totalDuration = mediaPlayer.getDuration();
                        int totalMinutes = (totalDuration / 1000) / 60;
                        int totalSeconds = (totalDuration / 1000) % 60;
                        String totalDurationStr = String.format(Locale.getDefault(), "%02d:%02d", totalMinutes, totalSeconds);
                        timeRemainingTextView.setText(totalDurationStr);
                    }
                    handler.postDelayed(this, 1000);
                }
            });
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Remove callbacks to prevent memory leaks
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            mediaPlayer.seekTo(progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        isSeeking = true;
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        isSeeking = false;
    }

}


