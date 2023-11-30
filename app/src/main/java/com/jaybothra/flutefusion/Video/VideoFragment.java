package com.jaybothra.flutefusion.Video;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jaybothra.flutefusion.R;

import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends Fragment {

    private RecyclerView recyclerView;
    private VideoAdapter videoAdapter;
    private List<Integer> videoList;
    private LinearLayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        videoList = new ArrayList<>();
        videoList.add(R.raw.vid1);
        videoList.add(R.raw.vid2);
        videoList.add(R.raw.vid3);
        videoList.add(R.raw.vid4);
        videoList.add(R.raw.vid5);
        videoList.add(R.raw.vid6);
        videoList.add(R.raw.vid7);



        List<String> videoTitles = new ArrayList<>();
        videoTitles.add("Kesariya - Flute");
        videoTitles.add("Dil Kyo Yeah Mera - Flute");
        videoTitles.add("Tera Yaar Hu Mai - Flute");
        videoTitles.add("Janmasthmi Special - Flute");
        videoTitles.add("Kal Ho na Ho  - Flute");
        videoTitles.add("Republic Day - Flute");
        videoTitles.add(" Main Rahoo Ya Na Rahoo - Flute");

        videoAdapter = new VideoAdapter(requireContext(), videoList, videoTitles);
        recyclerView.setAdapter(videoAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (videoAdapter != null) {
                        videoAdapter.stopPlayback();
                    }
                }
            }
        });
        return view;
    }
    @Override
    public void onPause() {
        super.onPause();
        if (videoAdapter != null) {
            videoAdapter.stopPlayback();
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (videoAdapter != null) {
            videoAdapter.stopPlayback();
        }
    }
}
