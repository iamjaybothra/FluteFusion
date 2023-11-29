package com.jaybothra.flutefusion.RecyclerView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaybothra.flutefusion.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StoreFragment extends Fragment implements RecyclerViewAdapter.OnAddToCartClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StoreFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StoreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StoreFragment newInstance(String param1, String param2) {
        StoreFragment fragment = new StoreFragment();
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
        View view = inflater.inflate(R.layout.fragment_store, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycle);

        // Set the layout manager before setting the adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<ListItems> listItems = new ArrayList<>();
        listItems.add(new ListItems(R.drawable.sample, "Traditional Bamboo Bansuri", "150", "100", R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Indian Bansuri with Carved Design", "200", "120",  R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Bansuri in Key of C", "180", "110",   R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Handcrafted Bansuri Flute", "220", "130",   R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Bamboo Bansuri with Velvet Bag", "250", "150",   R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Professional Bansuri - Key of G", "280", "170",   R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Bansuri for Beginners - Key of D", "120", "80",   R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Hand-Painted Bansuri with Peacock Design", "300", "180",   R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Bansuri Flute in Key of A", "210", "140",   R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Premium Quality Bansuri", "350", "200",   R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Rosewood Bansuri - Key of E", "270", "160",   R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Beginner's Bansuri with Instructional Booklet", "130", "90",   R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Bansuri in Key of Bb", "190", "120",   R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Artisan Crafted Bansuri", "320", "190",   R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Bansuri with Decorative Tassels", "230", "140",   R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Professional Bansuri - Key of F", "290", "170",   R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Bamboo Bansuri - Key of G#", "260", "150",   R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Exotic Bansuri with Brass Inlay", "380", "220",   R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "Traditional Bansuri with Velvet Case", "270", "160",   R.drawable.add));
        listItems.add(new ListItems(R.drawable.sample, "High-Quality Bansuri - Key of E", "330", "200",   R.drawable.add));


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(listItems, this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onAddToCartClicked(ListItems listItem) {
        // Navigate to StoreDetailFragment with clicked item's details using Navigation Component
        Bundle bundle = new Bundle();
        bundle.putParcelable("clicked_item", (Parcelable) listItem); // Passing clicked item's details

        // Assuming your action ID for navigating to StoreDetailFragment is nav_action_store_to_store_detail
        Navigation.findNavController(requireView()).navigate(
                R.id.action_nav_store_to_storeDetailFragment, bundle
        );
    }
}