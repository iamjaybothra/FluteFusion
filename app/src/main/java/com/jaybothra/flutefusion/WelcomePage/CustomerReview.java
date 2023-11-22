package com.jaybothra.flutefusion.WelcomePage;

public class CustomerReview {
    private int imageResId;
    private float rating;
    private String reviewText;

    public CustomerReview(int imageResId, float rating, String reviewText) {
        this.imageResId = imageResId;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
