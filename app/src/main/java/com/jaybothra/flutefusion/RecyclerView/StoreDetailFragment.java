package com.jaybothra.flutefusion.RecyclerView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaybothra.flutefusion.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StoreDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StoreDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StoreDetailFragment() {
        // Required empty public constructor
    }


    public static StoreDetailFragment newInstance(ListItems listItem) {
        StoreDetailFragment fragment = new StoreDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("clicked_item", (Parcelable) listItem); // Assuming ListItems is Parcelable
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
        View view =  inflater.inflate(R.layout.fragment_store_detail, container, false);
        ListItems clickedItem = getArguments().getParcelable("clicked_item");
        if (clickedItem != null) {

            TextView detailsFluteName = view.findViewById(R.id.details_flutename);
            ImageView detailsImage = view.findViewById(R.id.details_fluteImage);
            TextView price = view.findViewById(R.id.details_flutePrice);

            detailsFluteName.setText(clickedItem.getFluteName());
            detailsImage.setImageResource(clickedItem.getImage());
            price.setText("Price: $"+clickedItem.getPrice());


        }

        return view;

    }
}