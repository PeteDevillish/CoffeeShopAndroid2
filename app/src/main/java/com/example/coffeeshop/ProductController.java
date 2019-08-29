package com.example.coffeeshop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductController implements Callback<List<Product>> {

    static final String BASE_URL = "http://10.0.2.2:8080";
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        API API = retrofit.create(API.class);

        Call<List<Product>> call = API.loadChanges();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
        if(response.isSuccessful()) {
            final List<Product> productList = response.body();
//            System.out.println(response.body());
//            System.out.println(productList);
            products = productList;
            System.out.println(products);
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Product>> call, Throwable t) {
        t.printStackTrace();
    }
}
