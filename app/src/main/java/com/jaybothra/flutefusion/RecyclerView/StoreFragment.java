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



        listItems.add(new ListItems(
                R.drawable.combo,
                "Combo Set D Base E Base G Base A Base and C Medium Left Hand Bansuri (Flutes) in Matte Round Case",
                "1436.16",
                "1203.92",
                R.drawable.add,
                "FluteFusion Combo D Base E base G base A base C medium in Matte Round Case With Cleaning Rod")
        );
        listItems.add(new ListItems(
                R.drawable.d,
                "Professional Bamboo Flute (Right Hand) 23 Inches (58.5 cm) in G Natural Medium",
                "219.50",
                "169.99",
                R.drawable.add,
                "A professional quality bamboo flute with a rich tone in the G Natural Medium scale. Perfect for stage performances and recordings.")
        );
        listItems.add(new ListItems(
                R.drawable.set,
                "Full Set Premium Bansuri Flutes (Right Hand) Indian Bamboo Flutes",
                "3663.82",
                "2802.92",
                R.drawable.add,
                "These 25 flutes; being the only combination of base, medium and small size of Bansuri, are the best for any kind of music. Therefore these bansuri are combined in a set by us with good discount.. \n" +
                        "You will have to pay for 15 Bansuri and other 10 will be free along with a Flight case to accommodate these Bansuri/Bamboo flutes. ")
        );


        listItems.add(new ListItems(
                R.drawable.a,
                "C Natural Medium Bansuri Flute Clearance sale (Right Hand) 19.5 Inches (49 cm)",
                "162.84",
                "120.13",
                R.drawable.add,
                "C Natural Medium bamboo Flute/Bansuri is a professional quality medium sized Bansuri When the upper three holes are coverd by finger, it's the Indian C natural medium scale. Key note of G natural according to the western style playing. (when all the six holes are covered)"
        ));
        listItems.add(new ListItems(
                        R.drawable.c,
                        "Indian Bamboo Bansuri Flute - F Sharp Medium (Right Hand) 21 Inches (53 cm)",
                        "179.99",
                        "129.99",
                        R.drawable.add,
                        "An Indian F Sharp Medium bamboo flute that is handcrafted and designed for a beautiful sound output.")
                );

        listItems.add(new ListItems(
                        R.drawable.c,
                        "Handmade Bass Bamboo Bansuri Flute - D Natural (Right Hand) 30 Inches (76 cm)",
                        "249.99",
                        "199.99",
                        R.drawable.add,
                        "This handcrafted D Natural bass bamboo flute produces a deep, resonating sound. It's suitable for professional performances.")
                );
        listItems.add(new ListItems(
                R.drawable.b,
                "Bamboo Transverse Bansuri Flute - G Sharp Medium (Right Hand) 22 Inches (56 cm)",
                "199.99",
                "149.99",
                R.drawable.add,
                "This Bansuri is specially designed for beginners and has a standard quality G Sharp Medium scale. It's easy to play and provides a melodious tone.")
        );

        listItems.add(new ListItems(
                        R.drawable.c,
                        "Bamboo Bansuri Flute - E Natural Medium (Right Hand) 24 Inches (61 cm)",
                        "189.99",
                        "139.99",
                        R.drawable.add,
                        "A high-quality E Natural Medium bamboo flute that offers ease of playing and a beautiful tone suitable for both beginners and intermediate players.")
                );







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