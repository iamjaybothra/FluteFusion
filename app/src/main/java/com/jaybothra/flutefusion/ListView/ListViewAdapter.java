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

import com.jaybothra.flutefusion.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<TutorialItems> {

    public ListViewAdapter(Context context, ArrayList<TutorialItems> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.tutorial_row, parent, false);
        }

        TutorialItems currentItem = getItem(position);

        ImageView imageView = listItemView.findViewById(R.id.tutorial_image);
        TextView titleTextView = listItemView.findViewById(R.id.tutorial_title);
        TextView contentTextView = listItemView.findViewById(R.id.tutorial_content);

        if (currentItem != null) {
            imageView.setImageResource(currentItem.getImage());
            titleTextView.setText(currentItem.getSteps());
            contentTextView.setText(currentItem.getDetails());
        }

        return listItemView;
    }
}
