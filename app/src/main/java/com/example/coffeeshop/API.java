package com.example.coffeeshop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    @GET("allProducts")
    Call<List<Product>> getAllProducts();

    @GET("promoProducts")
    Call<List<Product>> getPromoProducts();

}
