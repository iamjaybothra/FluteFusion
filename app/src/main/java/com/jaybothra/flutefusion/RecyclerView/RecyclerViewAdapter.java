package com.jaybothra.flutefusion.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jaybothra.flutefusion.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Objects;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {

    ArrayList<Term> termArrayList;
    public RecyclerViewAdapter(ArrayList<Term> terms){
        this.termArrayList = terms;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row, null);

        return new CustomViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Term term = termArrayList.get(position);

        holder.image.setImageResource(term.getImage());
        holder.fluteName.setText(term.getFluteName());
        holder.priceCut.setText(term.getPriceCut());
        holder.price.setText(term.getPrice());
        holder.addToCart.setText(term.getAddToCart());
    }




    @Override
    public int getItemCount() {
        return termArrayList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        protected ImageView image;
        protected TextView fluteName;
        protected TextView priceCut;
        protected TextView price;
        protected TextView addToCart;

        public CustomViewHolder(View view){
            super(view);
            this.image = view.findViewById(R.id.recycle_image);
            this.fluteName = view.findViewById(R.id.recycle_product);
            this.priceCut = view.findViewById(R.id.recycle_cut_price);
            this.price = view.findViewById(R.id.recycle_price);
            this.addToCart = view.findViewById(R.id.recycle_button);

        }
    }
}
