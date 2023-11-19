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
        items.add(new TutorialItems("Tutorial 1", R.mipmap.ic_launcher, "Click to Check Details"));
        items.add(new TutorialItems("Tutorial 2", R.mipmap.ic_launcher, "Click to Check Details"));
        items.add(new TutorialItems("Tutorial 3", R.mipmap.ic_launcher, "Click to Check Details"));
        items.add(new TutorialItems("Tutorial 4", R.mipmap.ic_launcher, "Click to Check Details"));

        ListViewAdapter adapter = new ListViewAdapter(getContext(), items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("title", items.get(i).getSteps());
                bundle.putInt("image", items.get(i).getImage());
                bundle.putString("details", items.get(i).getDetails());

                Navigation.findNavController(view)
                        .navigate(R.id.action_nav_tutorial_to_tutorialDetailsFragment, bundle);
                Log.d("TutorialFragment", "Item Clicked: " + items.get(i).getSteps());
            }
        });

        return view;
    }



}