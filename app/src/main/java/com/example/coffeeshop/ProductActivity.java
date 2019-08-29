package com.example.coffeeshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductActivity extends AppCompatActivity {

    static final String BASE_URL = "http://10.0.2.2:8080";
    private ListView products;
    private TextView error;
    private API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        products = (ListView) findViewById(R.id.products);
        error = (TextView) findViewById(R.id.errorView);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(API.class);

        getProducts();
    }
    private void getProducts(){
        Call<List<Product>> call = api.loadChanges();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (!response.isSuccessful()) {
                    error.setText("Code: " + response.code());
                    return;
                }
                ArrayList<Product> productList = (ArrayList<Product>) response.body();

                ProductAdapter promoAdapter = new ProductAdapter(ProductActivity.this, productList);

                ListView promoProducts = (ListView) findViewById(R.id.products);

                promoProducts.setAdapter(promoAdapter);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                error.setText(t.getMessage());
            }
        });
    }

}
