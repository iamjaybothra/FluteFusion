package com.jaybothra.flutefusion.ViewPager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaybothra.flutefusion.R;

public class MaintainFragment extends Fragment {


    private static final String ARG_IMAGE_RESOURCE = "vp_img";
    private static final String ARG_TITLE = "vp_title";
    private static final String ARG_TEXT1 = "vp1";
    private static final String ARG_TEXT2 = "vp2";
    private static final String ARG_TEXT3 = "vp3";

    private int vpImg;
    private String vpTitle;
    private String vpt1;
    private String vpt2;
    private String vpt3;

    public MaintainFragment() {
        // Required empty public constructor
    }

    public static MaintainFragment newInstance(String vpTitle, int vpImg, String vpt1, String vpt2, String vpt3) {
        MaintainFragment fragment = new MaintainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, vpTitle);
        args.putInt(ARG_IMAGE_RESOURCE, vpImg);
        args.putString(ARG_TEXT1, vpt1);
        args.putString(ARG_TEXT2, vpt2);
        args.putString(ARG_TEXT3, vpt3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            vpTitle = getArguments().getString(ARG_TITLE);
            vpImg = getArguments().getInt(ARG_IMAGE_RESOURCE);
            vpt1 = getArguments().getString(ARG_TEXT1);
            vpt2 = getArguments().getString(ARG_TEXT2);
            vpt3 = getArguments().getString(ARG_TEXT3);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_maintain, container, false);
        TextView VPTitle = view.findViewById(R.id.vp_title);
        ImageView VPImage = view.findViewById(R.id.vp_img);
        TextView VPT1 = view.findViewById(R.id.vp1);
        TextView VPT2 = view.findViewById(R.id.vp2);
        TextView VPT3 = view.findViewById(R.id.vp3);


        VPTitle.setText(vpTitle);
        VPImage.setImageResource(vpImg);
        VPT1.setText(vpt1);
        VPT2.setText(vpt2);
        VPT3.setText(vpt3);


        return view;
    }
}