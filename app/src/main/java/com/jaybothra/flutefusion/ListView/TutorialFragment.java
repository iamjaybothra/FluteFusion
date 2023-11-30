package com.jaybothra.flutefusion.ListView;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;

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



        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        String selectedTutorialLevel = preferences.getString("tutorial_level", "beginner");

        ArrayList<TutorialItems> items = new ArrayList<>();

        if (selectedTutorialLevel.equals("beginner")) {
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
                    TContent.T4_DETAILS5));
        }
        else if (selectedTutorialLevel.equals("intermediate")) {
            items.add(new TutorialItems(TContent.IT5_TITLE,
                    TContent.IT5_IMAGE,
                    "1.) " + TContent.IT5_DETAILS1,
                    "2.) " + TContent.IT5_DETAILS2,
                    TContent.IT5_DETAILS3,
                     TContent.IT5_DETAILS4,
                    TContent.IT5_DETAILS5));
            items.add(new TutorialItems(TContent.IT2,
                    TContent.IIMG2,
                    "1.) " + TContent.I2D1,
                     "2.)" + TContent.I2D2,
                     TContent.I2D3,
                    TContent.I2D4,
                    TContent.I2D5));
            items.add(new TutorialItems(TContent.IT3,
                    TContent.IIMG3,
                    "1.) " + TContent.I3D1,
                    TContent.I3D2,
                    TContent.I3D3,
                    TContent.I3D4,
                    TContent.I3D5));
            items.add(new TutorialItems(TContent.IT4,
                    TContent.IIMG4,
                    "1.) " + TContent.I4D1,
                    "2.) " + TContent.I4D2,
                     TContent.I4D3,
                    TContent.I4D4,
                     TContent.I4D5));
            items.add(new TutorialItems(TContent.IT5,
                    TContent.IIMG5,
                    "1.) " + TContent.I5D1,
                    "2.) " +  TContent.I5D2,
                    "3.) " + TContent.I5D3,
                    TContent.I5D4,
                     TContent.I5D5));

        }
        else if (selectedTutorialLevel.equals("advanced")) {
            items.add(new TutorialItems(TContent.AT1_TITLE,
                    TContent.AIMG,
                    "1.) " + TContent.A1D1,
                    TContent.A1D2,
                    TContent.A1D3,
                    TContent.A1D4,
                    TContent.A1D5));

            items.add(new TutorialItems(TContent.AT2_TITLE,
                    TContent.AIMG2,
                    "1.) " + TContent.A2D1,
                    "2.) " + TContent.A2D2,
                    "3.) " + TContent.A2D3,
                    "4.) " + TContent.A2D4,
                    TContent.A2D5));

            items.add(new TutorialItems(TContent.AT3_TITLE,
                    TContent.AIMG3,
                    "1.) " + TContent.A3D1,
                    "2.) " + TContent.A3D2,
                    TContent.A3D3,
                    TContent.A3D4,
                    TContent.A3D5));

            items.add(new TutorialItems(TContent.AT4_TITLE,
                    TContent.AIMG4,
                    "1.) " + TContent.A4D1,
                    TContent.A4D2,
                    TContent.A4D3,
                    TContent.A4D4,
                    TContent.A4D5));
            items.add(new TutorialItems(TContent.AT5_TITLE,
                    TContent.AIMG5,
                    "1.) " + TContent.A5D1,
                    "2.) " + TContent.A5D2,
                    TContent.A5D3,
                    TContent.A5D4,
                    TContent.A5D5));
            items.add(new TutorialItems(TContent.AT6_TITLE,
                    TContent.AIMG6,
                    "1.) " + TContent.A6D1,
                    "2.) " + TContent.A6D2,
                    "3.) " + TContent.A6D3,
                    TContent.A6D4,
                    TContent.A6D5));



        }






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