package com.example.coffeeshop;

public class Product {

    private float mRating;
    private int mImageResourceId;
    private String mNameOfProduct;
    private double mPromoPrice;
    private double mRegularprice;

    public Product(float rating, int imageResourceId, String nameOfProduct, double regularprice) {
        this.mRating = rating;
        this.mImageResourceId = imageResourceId;
        this.mNameOfProduct = nameOfProduct;
        this.mRegularprice = regularprice;
    }

    public Product(float rating, int imageResourceId, String nameOfProduct, double promoPrice, double regularPrice) {
        this.mRating = rating;
        this.mImageResourceId = imageResourceId;
        this.mNameOfProduct = nameOfProduct;
        this.mPromoPrice = promoPrice;
        this.mRegularprice = regularPrice;
    }

    public float getRating() {
        return mRating;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getNameOfProduct() {
        return mNameOfProduct;
    }

    public double getPromoPrice() {
        return mPromoPrice;
    }

    public double getRegularPrice() {
        return mRegularprice;
    }


}
