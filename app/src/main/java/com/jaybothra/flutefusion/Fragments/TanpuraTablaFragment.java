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
    private Handler handler;
    private TextView timeRemainingTextView;
    private boolean isPlaying = false;
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";

    public TanpuraTablaFragment() {
        // Constructor
    }

    public static TanpuraTablaFragment newInstance(String param1, String param2) {
        // New Instance method
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
        int audioResource = R.raw.tanpura_c; // Default audio resource
        switch (selectedAudio) {
            case "tanpura_a": audioResource = R.raw.tanpura_a; break;
            case "tanpura_b": audioResource = R.raw.tanpura_b; break;
            case "tanpura_c": audioResource = R.raw.tanpura_c; break;
            case "tanpura_csharp": audioResource = R.raw.tanpura_csharp; break;
            case "tanpura_d": audioResource = R.raw.tanpura_d; break;
            case "tanpura_dsharp": audioResource = R.raw.tanpura_dsharp; break;
            case "tanpura_e": audioResource = R.raw.tanpura_e; break;
            case "tanpura_f": audioResource = R.raw.tanpura_f; break;
            case "tanpura_fsharp": audioResource = R.raw.tanpura_fsharp; break;
            case "tanpura_g": audioResource = R.raw.tanpura_g; break;
            case "tanpura_gsharp": audioResource = R.raw.tanpura_gsharp; break;
        }
        return MediaPlayer.create(requireContext(), audioResource);
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tanpura_tabla, container, false);

        seekBar = view.findViewById(R.id.seekBar);
        btnPlay = view.findViewById(R.id.btnPlay);
        btnPause = view.findViewById(R.id.btnPause);
        timeRemainingTextView = view.findViewById(R.id.timeline);
        seekBar.setOnSeekBarChangeListener(this);
        handler = new Handler();
        mediaPlayer = getSelectedMediaPlayer();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    if (!isPlaying) {
                        mediaPlayer.start();
                        btnPlay.setVisibility(View.GONE);
                        btnPause.setVisibility(View.VISIBLE);
                        startSeekBarUpdate();
                        isPlaying = true;
                    }
                }
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    if (isPlaying) {
                        mediaPlayer.pause();
                        btnPlay.setVisibility(View.VISIBLE);
                        btnPause.setVisibility(View.GONE);
                        isPlaying = false;
                    }
                }
            }
        });

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

        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    btnPlay.setVisibility(View.VISIBLE);
                    btnPause.setVisibility(View.GONE);
                }
            });
        }

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
                    int currentPosition = mediaPlayer.getCurrentPosition();
                    int totalDuration = mediaPlayer.getDuration();

                    int timeRemaining = totalDuration - currentPosition;

                    int minutes = (timeRemaining / 1000) / 60;
                    int seconds = (timeRemaining / 1000) % 60;
                    String timeRemainingStr = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

                    timeRemainingTextView.setText(timeRemainingStr);
                    seekBar.setProgress(currentPosition);

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

