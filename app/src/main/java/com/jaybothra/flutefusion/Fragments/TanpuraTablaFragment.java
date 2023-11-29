package com.jaybothra.flutefusion.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.media.MediaPlayer;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.jaybothra.flutefusion.R;

import java.util.Arrays;
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
    }

    public static TanpuraTablaFragment newInstance(String param1, String param2) {
        TanpuraTablaFragment fragment = new TanpuraTablaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private MediaPlayer getSelectedMediaPlayer() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        String selectedAudio = preferences.getString("selected_audio_key", "default_value");

        if (selectedAudio.equals("newclass")) {
            return MediaPlayer.create(getActivity(), R.raw.newclass);
        } else if (selectedAudio.equals("tanpura_a")) {
            return MediaPlayer.create(getActivity(), R.raw.tanpura_a);
        }else if (selectedAudio.equals("tanpura_b")) {
            return MediaPlayer.create(getActivity(), R.raw.tanpura_b);
        }else if (selectedAudio.equals("tanpura_c")) {
            return MediaPlayer.create(getActivity(), R.raw.tanpura_c);
        }else if (selectedAudio.equals("tanpura_csharp")) {
            return MediaPlayer.create(getActivity(), R.raw.tanpura_csharp);
        }else if (selectedAudio.equals("tanpura_d")) {
            return MediaPlayer.create(getActivity(), R.raw.tanpura_d);
        }else if (selectedAudio.equals("tanpura_dsharp")) {
            return MediaPlayer.create(getActivity(), R.raw.tanpura_dsharp);
        }else if (selectedAudio.equals("tanpura_e")) {
            return MediaPlayer.create(getActivity(), R.raw.tanpura_e);
        }else if (selectedAudio.equals("tanpura_f")) {
            return MediaPlayer.create(getActivity(), R.raw.tanpura_f);
        }else if (selectedAudio.equals("tanpura_fsharp")) {
            return MediaPlayer.create(getActivity(), R.raw.tanpura_fsharp);
        }else if (selectedAudio.equals("tanpura_g")) {
            return MediaPlayer.create(getActivity(), R.raw.tanpura_g);
        }else if (selectedAudio.equals("tanpura_gsharp")) {
            return MediaPlayer.create(getActivity(), R.raw.tanpura_gsharp);
        }


        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tanpura_tabla, container, false);

        mediaPlayer = getSelectedMediaPlayer();

        seekBar = view.findViewById(R.id.seekBar);
        btnPlay = view.findViewById(R.id.btnPlay);
        btnPause = view.findViewById(R.id.btnPause);
        timeRemainingTextView = view.findViewById(R.id.timeline);
        seekBar.setOnSeekBarChangeListener(this);
        handler = new Handler();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        String[] scaleNames = getResources().getStringArray(R.array.audio_list_titles);
        String selectedScale = preferences.getString("selected_audio_key", "default_value");

        TextView scaleNameTextView = view.findViewById(R.id.scale_name);
        int selectedIndex = Arrays.asList(getResources().getStringArray(R.array.audio_list_values)).indexOf(selectedScale);
        if (selectedIndex != -1 && selectedIndex < scaleNames.length) {
            scaleNameTextView.setText(scaleNames[selectedIndex]);
        } else {
            scaleNameTextView.setText("Scale Name");
        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    btnPlay.setVisibility(View.GONE);
                    btnPause.setVisibility(View.VISIBLE);
                    startSeekBarUpdate();
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
    @Override
    public void onPause() {
        super.onPause();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            btnPlay.setVisibility(View.VISIBLE);
            btnPause.setVisibility(View.GONE);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
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

                        int timeRemaining = totalDuration - currentPosition;

                        int minutes = (timeRemaining / 1000) / 60;
                        int seconds = (timeRemaining / 1000) % 60;
                        String timeRemainingStr = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

                        timeRemainingTextView.setText(timeRemainingStr);
                        seekBar.setProgress(currentPosition);
                    }else {
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


