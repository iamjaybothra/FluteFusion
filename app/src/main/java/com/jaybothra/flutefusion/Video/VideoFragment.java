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
import com.jaybothra.flutefusion.Video.VideoAdapter;

import java.util.ArrayList;
import java.util.List;

// VideoFragment.java
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

        // Set up RecyclerView layout manager and adapter
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        videoList = new ArrayList<>();
        videoList.add(R.raw.vid1);
        videoList.add(R.raw.vid2);

        List<String> videoTitles = new ArrayList<>();
        videoTitles.add("Title 1");
        videoTitles.add("Title 2");

        videoAdapter = new VideoAdapter(requireContext(), videoList, videoTitles);
        recyclerView.setAdapter(videoAdapter);

        return view;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (videoAdapter != null) {
            videoAdapter.releasePlayer();
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        videoAdapter.releasePlayer();
    }
}
