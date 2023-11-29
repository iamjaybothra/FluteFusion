package com.jaybothra.flutefusion.RecyclerView;

import android.os.Parcel;
import android.os.Parcelable;

public class ListItems implements Parcelable {
    private int image;
    private String fluteName;
    private String priceCut;
    private String price;
    private int addToCart;
    private String description;

    public ListItems(int image, String fluteName, String priceCut, String price, int addToCart, String description) {
        this.image = image;
        this.fluteName = fluteName;
        this.priceCut = priceCut;
        this.price = price;
        this.addToCart = addToCart;
        this.description = description;
    }

    // Parcelable implementation
    protected ListItems(Parcel in) {
        image = in.readInt();
        fluteName = in.readString();
        priceCut = in.readString();
        price = in.readString();
        addToCart = in.readInt();
        description = in.readString();
    }

    public static final Creator<ListItems> CREATOR = new Creator<ListItems>() {
        @Override
        public ListItems createFromParcel(Parcel in) {
            return new ListItems(in);
        }

        @Override
        public ListItems[] newArray(int size) {
            return new ListItems[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(fluteName);
        dest.writeString(priceCut);
        dest.writeString(price);
        dest.writeInt(addToCart);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getFluteName() {
        return fluteName;
    }

    public void setFluteName(String fluteName) {
        this.fluteName = fluteName;
    }

    public String getPriceCut() {
        return "Price Before: $"+priceCut;
    }

    public void setPriceCut(String priceCut) {
        this.priceCut = priceCut;
    }

    public String getPrice() {
        return "Current Price: $"+price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getAddToCart() {
        return addToCart;
    }

    public void setAddToCart(int addToCart) {
        this.addToCart = addToCart;
    }

    @Override
    public String toString() {
        return fluteName;
    }


}
