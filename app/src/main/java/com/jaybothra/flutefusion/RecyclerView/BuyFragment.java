package com.jaybothra.flutefusion.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jaybothra.flutefusion.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BuyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BuyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BuyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BuyFragment newInstance(String param1, String param2) {
        BuyFragment fragment = new BuyFragment();
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
        View view = inflater.inflate(R.layout.fragment_buy, container, false);
        ListItems selectedProduct = getArguments().getParcelable("selected_item");
        if (selectedProduct != null) {

            ImageView productImage = view.findViewById(R.id.product_image);
            TextView productName = view.findViewById(R.id.product_name);
            TextView productPrice = view.findViewById(R.id.product_price);

            productImage.setImageResource(selectedProduct.getImage());
            productName.setText(selectedProduct.getFluteName());
            productPrice.setText(selectedProduct.getPrice());
        }
        Button buyButton = view.findViewById(R.id.buttonBuy);

        buyButton.setOnClickListener(e->{
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setTitle("Confirm Purchase")
                    .setMessage("Are you sure you want to purchase this item?")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                            builder.setTitle("Item Purchased")
                                    .setMessage("Your item has been purchased.")
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            // User clicked OK on the second dialog, navigate to the home fragment
                                            Navigation.findNavController(getView())
                                                    .navigate(R.id.action_nav_buy_to_nav_welcome);
                                        }
                                    })
                                    .show();                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
        });
        return view;
    }


}
