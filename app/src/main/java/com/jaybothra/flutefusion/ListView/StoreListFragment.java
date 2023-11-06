package com.jaybothra.flutefusion.ListView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.jaybothra.flutefusion.JavaBeans.ListItems;
import com.jaybothra.flutefusion.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StoreListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StoreListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StoreListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StoreListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StoreListFragment newInstance(String param1, String param2) {
        StoreListFragment fragment = new StoreListFragment();
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


        View view = inflater.inflate(R.layout.fragment_store_list, container, false);


        ListView listView = view.findViewById(R.id.dataTypeList);


        ArrayList<ListItems> listItems = new ArrayList<>();


        listItems.add(new ListItems(R.mipmap.ic_launcher, "Traditional Bamboo Bansuri", "150", "100", "Add To Cart"));
        listItems.add(new ListItems(R.mipmap.ic_launcher, "Indian Bansuri with Carved Design", "200", "120", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "Bansuri in Key of C", "180", "110", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "Handcrafted Bansuri Flute", "220", "130", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "Bamboo Bansuri with Velvet Bag", "250", "150", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "Professional Bansuri - Key of G", "280", "170", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "Bansuri for Beginners - Key of D", "120", "80", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "Hand-Painted Bansuri with Peacock Design", "300", "180", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "Bansuri Flute in Key of A", "210", "140", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "Premium Quality Bansuri", "350", "200", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "Rosewood Bansuri - Key of E", "270", "160", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "Beginner's Bansuri with Instructional Booklet", "130", "90", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "Bansuri in Key of Bb", "190", "120", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "Artisan Crafted Bansuri", "320", "190", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "Bansuri with Decorative Tassels", "230", "140", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "Professional Bansuri - Key of F", "290", "170", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "Bamboo Bansuri - Key of G#", "260", "150", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "Exotic Bansuri with Brass Inlay", "380", "220", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "Traditional Bansuri with Velvet Case", "270", "160", "Add To Cart"));
        listItems.add(new ListItems(R.drawable.sample, "High-Quality Bansuri - Key of E", "330", "200", "Add To Cart"));


        ListViewAdapter adapter2 = new ListViewAdapter(getContext(), listItems);




        listView.setAdapter(adapter2);
        return view;
    }
}