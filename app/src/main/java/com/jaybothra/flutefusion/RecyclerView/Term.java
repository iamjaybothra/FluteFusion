package com.jaybothra.flutefusion.RecyclerView;

public class Term {
    private int image;
    private String fluteName;
    private String priceCut;
    private String price;
    private String addToCart;

    public Term(int image, String fluteName, String priceCut, String price, String addToCart) {
        this.image = image;
        this.fluteName = fluteName;
        this.priceCut = priceCut;
        this.price = price;
        this.addToCart = addToCart;
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
        return priceCut;
    }

    public void setPriceCut(String priceCut) {
        this.priceCut = priceCut;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String  getAddToCart() {
        return addToCart;
    }

    public void setAddToCart(String addToCart) {
        this.addToCart = addToCart;
    }

    @Override
    public String toString() {
        return fluteName;
    }
}
