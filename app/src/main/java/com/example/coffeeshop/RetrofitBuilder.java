package com.example.coffeeshop;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder{

    static final String BASE_URL = "http://10.0.2.2:8080";
    private static API api;

    public static API start(){

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    api = retrofit.create(API.class);
    return api;
    }

}
