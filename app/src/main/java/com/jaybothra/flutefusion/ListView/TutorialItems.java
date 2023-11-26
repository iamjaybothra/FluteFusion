package com.jaybothra.flutefusion.ListView;

import android.media.Image;

public class TutorialItems {
    private String steps;
    private int image;

    private String details;
    private String details1;
    private String details2;
    private String details3;
    private String details4;

    public TutorialItems(String steps, int image, String details, String details1, String details2, String details3, String details4) {
        this.steps = steps;
        this.image = image;
        this.details = details;
        this.details1 = details1;
        this.details2 = details2;
        this.details3 = details3;
        this.details4 = details4;
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

    public String getDetails1() {
        return details1;
    }

    public void setDetails1(String details1) {
        this.details1 = details1;
    }

    public String getDetails2() {
        return details2;
    }

    public void setDetails2(String details2) {
        this.details2 = details2;
    }

    public String getDetails3() {
        return details3;
    }

    public void setDetails3(String details3) {
        this.details3 = details3;
    }

    public String getDetails4() {
        return details4;
    }

    public void setDetails4(String details4) {
        this.details4 = details4;
    }

    @Override
    public String toString() {
        return steps;
    }
}
