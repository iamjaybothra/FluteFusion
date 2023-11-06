package com.jaybothra.flutefusion.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jaybothra.flutefusion.JavaBeans.ListItems;
import com.jaybothra.flutefusion.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {

    ArrayList<ListItems> listItemsArrayList;
    public RecyclerViewAdapter(ArrayList<ListItems> listItems){
        this.listItemsArrayList = listItems;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, null);

        return new CustomViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        ListItems listItems = listItemsArrayList.get(position);

        holder.image.setImageResource(listItems.getImage());
        holder.fluteName.setText(listItems.getFluteName());
        holder.priceCut.setText(listItems.getPriceCut());
        holder.price.setText(listItems.getPrice());
        holder.addToCart.setText(listItems.getAddToCart());
    }




    @Override
    public int getItemCount() {
        return listItemsArrayList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        protected ImageView image;
        protected TextView fluteName;
        protected TextView priceCut;
        protected TextView price;
        protected TextView addToCart;

        public CustomViewHolder(View view){
            super(view);
            this.image = view.findViewById(R.id.list_image);
            this.fluteName = view.findViewById(R.id.list_product);
            this.priceCut = view.findViewById(R.id.list_cutPrice);
            this.price = view.findViewById(R.id.list_price);
            this.addToCart = view.findViewById(R.id.list_addToCart);

        }
    }
}
