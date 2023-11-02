package com.jaybothra.flutefusion.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jaybothra.flutefusion.JavaBeans.ListItems;
import com.jaybothra.flutefusion.R;

import java.util.ArrayList;


public class ListViewAdapter extends ArrayAdapter<ListItems> {
    public ListViewAdapter(@NonNull Context context, ArrayList<ListItems> resource) {
        super(context, 0, resource); // Change the second argument to 0
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ListItems item = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);

            ImageView image = convertView.findViewById(R.id.list_image);
            TextView product = convertView.findViewById(R.id.list_product);
            TextView cutPrice = convertView.findViewById(R.id.list_cutPrice);
            TextView price = convertView.findViewById(R.id.list_price);
            TextView addToCart = convertView.findViewById(R.id.list_addToCart);

            image.setImageResource(item.getImage());
            product.setText(item.getFluteName());
            cutPrice.setText(item.getPriceCut());
            price.setText(item.getPrice());
            addToCart.setText(item.getAddToCart());
        }
        return convertView;
    }
}
