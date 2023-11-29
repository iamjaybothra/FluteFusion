package com.jaybothra.flutefusion.WelcomePage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaybothra.flutefusion.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelcomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelcomeFragment extends Fragment {
    private ViewPager viewPager;
    private CustomerReviewPagerAdapter adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WelcomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WelcomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WelcomeFragment newInstance(String param1, String param2) {
        WelcomeFragment fragment = new WelcomeFragment();
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        viewPager = view.findViewById(R.id.viewPagerCustomerReviews);
        Button storeBtn = view.findViewById(R.id.storeBtn);
        Button maintainBtn = view.findViewById(R.id.maintainBtn);
        Button tutorialBtn = view.findViewById(R.id.tutorialBtn);
        Button audioBtn = view.findViewById(R.id.audioBtn);

        List<CustomerReview> customerReviews = new ArrayList<>();
        customerReviews.add(new CustomerReview(R.drawable.sample, 5f, "Great app! Very useful."));
        customerReviews.add(new CustomerReview(R.drawable.sample, 4f, "Highly recommended!"));
        customerReviews.add(new CustomerReview(R.drawable.sample, 5f, "I love the features."));
        customerReviews.add(new CustomerReview(R.drawable.sample, 3f, "Easy to use and intuitive."));
        customerReviews.add(new CustomerReview(R.drawable.sample, 4.5f, "Awesome app!"));
        customerReviews.add(new CustomerReview(R.drawable.sample, 4f, "Useful features."));
        customerReviews.add(new CustomerReview(R.drawable.sample, 3.5f, "Decent app."));
        customerReviews.add(new CustomerReview(R.drawable.sample, 5f, "Absolutely amazing!"));
        customerReviews.add(new CustomerReview(R.drawable.sample, 4.5f, "Great functionalities."));
        customerReviews.add(new CustomerReview(R.drawable.sample, 1f, "Apps have bugs."));
        customerReviews.add(new CustomerReview(R.drawable.sample, 4.5f, "Satisfied with the app."));
        customerReviews.add(new CustomerReview(R.drawable.sample, 3.5f, "Good but needs updates."));
        customerReviews.add(new CustomerReview(R.drawable.sample, 2.5f, "Needs improvement."));
        customerReviews.add(new CustomerReview(R.drawable.sample, 2.5f, "Not user-friendly."));
        customerReviews.add(new CustomerReview(R.drawable.sample, 3f, "Okayish app."));
        customerReviews.add(new CustomerReview(R.drawable.sample, 2f, "Disappointed with performance."));



        adapter = new CustomerReviewPagerAdapter(customerReviews);
        viewPager.setAdapter(adapter);

        storeBtn.setOnClickListener(e->{
            Navigation.findNavController(view)
                    .navigate(R.id.action_nav_welcome_to_nav_store);
        });

        maintainBtn.setOnClickListener(e->{
            Navigation.findNavController(view)
                    .navigate(R.id.action_nav_welcome_to_nav_maintain);
        });

        tutorialBtn.setOnClickListener(e->{
            Navigation.findNavController(view)
                    .navigate(R.id.action_nav_welcome_to_nav_tutorial);
        });

        audioBtn.setOnClickListener(e->{
            Navigation.findNavController(view)
                    .navigate(R.id.action_nav_welcome_to_nav_audio);
        });

        return view;
    }

}