package com.jaybothra.flutefusion.ListView;

import android.media.Image;

public class TutorialItems {
    private String steps;
    private int image;

    private String details;

    public TutorialItems( String steps, int image, String details) {
        this.steps = steps;
        this.image = image;

        this.details = details;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return steps;
    }
}
