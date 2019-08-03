package com.example.coffeeshop;

import com.squareup.picasso.Picasso;

public class Product {

    private float mRating;
    private int mImageResourceId;
    private String mNameOfProduct;
    private double mPromoPrice;
    private double mRegularprice;
    private String mPath;
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

    public Product(float mRating, String mPath, String mNameOfProduct, double mPromoPrice, double mRegularprice) {
        this.mRating = mRating;
        this.mNameOfProduct = mNameOfProduct;
        this.mPromoPrice = mPromoPrice;
        this.mRegularprice = mRegularprice;
        this.mPath = mPath;
    }

    public String getPath() {
        return mPath;
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
