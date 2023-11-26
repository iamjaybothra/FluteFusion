package com.jaybothra.flutefusion.ListView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jaybothra.flutefusion.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TutorialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TutorialFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TutorialFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TutorialFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TutorialFragment newInstance(String param1, String param2) {
        TutorialFragment fragment = new TutorialFragment();
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
        View view = inflater.inflate(R.layout.fragment_tutorial, container, false);

        ListView listView = view.findViewById(R.id.listview);

        ArrayList<TutorialItems> items = new ArrayList<>();
        items.add(new TutorialItems(TContent.T1_TITLE,
                TContent.T1_IMAGE,
                "1.) " + TContent.T1_DETAILS1,
                "2.) " + TContent.T1_DETAILS2,
                "3.) " + TContent.T1_DETAILS3,
                "4.) " + TContent.T1_DETAILS4,
                "5.) " + TContent.T1_DETAILS5));
        items.add(new TutorialItems(TContent.T2_TITLE,
                TContent.T2_IMAGE,
                "1.) " + TContent.T2_DETAILS1,
                "2.) " + TContent.T2_DETAILS2,
                "3.) " + TContent.T2_DETAILS3,
                "4.) " + TContent.T2_DETAILS4,
                "5.) " + TContent.T2_DETAILS5));
        items.add(new TutorialItems(TContent.T3_TITLE,
                TContent.T3_IMAGE,
                "1.) " + TContent.T3_DETAILS1,
                "2.) " + TContent.T3_DETAILS2,
                "3.) " + TContent.T3_DETAILS3,
                "4.) " + TContent.T3_DETAILS4,
                "5.) " + TContent.T3_DETAILS5));
        items.add(new TutorialItems(TContent.T4_TITLE,
                TContent.T4_IMAGE,
                "1.) " + TContent.T4_DETAILS1,
                "2.) " + TContent.T4_DETAILS2,
                "3.) " + TContent.T4_DETAILS3,
                "4.) " + TContent.T4_DETAILS4,
                "5.) " + TContent.T4_DETAILS5));
        items.add(new TutorialItems(TContent.T5_TITLE,
                TContent.T5_IMAGE,
                "1.) " + TContent.T5_DETAILS1,
                "2.) " + TContent.T5_DETAILS2,
                "3.) " + TContent.T5_DETAILS3,
                "4.) " + TContent.T5_DETAILS4,
                "5.) " + TContent.T5_DETAILS5));

        ListViewAdapter adapter = new ListViewAdapter(getContext(), items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("title", items.get(i).getSteps());
                bundle.putInt("image", items.get(i).getImage());
                bundle.putString("details", items.get(i).getDetails());
                bundle.putString("details1", items.get(i).getDetails1());
                bundle.putString("details2", items.get(i).getDetails2());
                bundle.putString("details3", items.get(i).getDetails3());
                bundle.putString("details4", items.get(i).getDetails4());

                Navigation.findNavController(view)
                        .navigate(R.id.action_nav_tutorial_to_tutorialDetailsFragment, bundle);
                Log.d("TutorialFragment", "Item Clicked: " + items.get(i).getSteps());
            }
        });

        return view;
    }



}