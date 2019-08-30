package com.example.coffeeshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductItemActivity extends AppCompatActivity {

    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_item);
        Gson gson = new Gson();
        product = gson.fromJson(getIntent().getStringExtra("product"), Product.class);
        System.out.println(product);
        ProductAdapter productAdapter = new ProductAdapter(ProductItemActivity.this, new ArrayList<Product>(Arrays.asList(product)));
        ListView product = (ListView) findViewById(R.id.item);
        product.setAdapter(productAdapter);
    }
}
