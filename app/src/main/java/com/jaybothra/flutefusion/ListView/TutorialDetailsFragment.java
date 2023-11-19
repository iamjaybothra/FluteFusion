package com.jaybothra.flutefusion.ListView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaybothra.flutefusion.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TutorialDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TutorialDetailsFragment extends Fragment {
    private TextView stepsTextView;
    private ImageView imageView;
    private TextView detailsTextView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TutorialDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TutorialDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TutorialDetailsFragment newInstance(String param1, String param2) {
        TutorialDetailsFragment fragment = new TutorialDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_tutorial_details, container, false);

        TextView stepsTextView = view.findViewById(R.id.d_steps);
        ImageView imageView = view.findViewById(R.id.d_img);
        TextView detailsTextView = view.findViewById(R.id.d_details);


        // Retrieve arguments
        Bundle args = getArguments();
        if (args != null) {
            String title = args.getString("title");
            int imageResource = args.getInt("image");
            String details = args.getString("details");

            // Set data to views
            stepsTextView.setText(title);
            imageView.setImageResource(imageResource);
            detailsTextView.setText(details);
        }

        return view;

    }
}