package com.jaybothra.flutefusion.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jaybothra.flutefusion.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {
    private OnAddToCartClickListener addToCartClickListener;

    ArrayList<ListItems> listItemsArrayList;
    public RecyclerViewAdapter(ArrayList<ListItems> listItems, OnAddToCartClickListener listener) {
        this.listItemsArrayList = listItems;
        this.addToCartClickListener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new CustomViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        ListItems listItems = listItemsArrayList.get(position);

        holder.image.setImageResource(listItems.getImage());
        holder.fluteName.setText(listItems.getFluteName());
        holder.priceCut.setText(listItems.getPriceCut());
        holder.price.setText(listItems.getPrice());
        holder.addToCart.setImageResource(listItems.getAddToCart());
        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCartClickListener.onAddToCartClicked(listItems);
            }
        });

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
        protected ImageView addToCart;

        public CustomViewHolder(View view){
            super(view);
            this.image = view.findViewById(R.id.list_image);
            this.fluteName = view.findViewById(R.id.list_product);
            this.priceCut = view.findViewById(R.id.list_cutPrice);
            this.price = view.findViewById(R.id.list_price);
            this.addToCart = view.findViewById(R.id.list_cart);

        }
    }

    public interface OnAddToCartClickListener {
        void onAddToCartClicked(ListItems listItem);
    }
}
