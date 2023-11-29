package com.jaybothra.flutefusion.WelcomePage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.jaybothra.flutefusion.R;

import java.util.List;

public class CustomerReviewPagerAdapter extends PagerAdapter {
    private List<CustomerReview> reviews;

    CustomerReviewPagerAdapter(List<CustomerReview> reviews) {
        this.reviews = reviews;
    }

    @Override
    public int getCount() {
        return reviews.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup parent, int position) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.customer_list_review, parent, false);

        ImageView customerImageView = view.findViewById(R.id.c_img);
        RatingBar ratingBar = view.findViewById(R.id.c_rating);
        TextView reviewTextView = view.findViewById(R.id.c_text);

        CustomerReview review = reviews.get(position);

        customerImageView.setImageResource(review.getImageResId());
        ratingBar.setRating(review.getRating());
        reviewTextView.setText(review.getReviewText());
        ratingBar.setClickable(false);
        ratingBar.setIsIndicator(true);


        parent.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
