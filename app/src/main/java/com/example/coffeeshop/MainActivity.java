package com.example.coffeeshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CarouselView carouselView;
    private API api;

    int[] sampleImages = {R.drawable.image_1, R.drawable.image_2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCarouselView();

        api = RetrofitBuilder.start();

        getPromoProducts();

        setFirstButton();
    }

    private void setFirstButton() {
        Button btn = (Button) findViewById(R.id.button0);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ProductActivity.class);
                startActivity(myIntent);
            }
        });
    }

    private void setCarouselView() {
        ImageListener imageListener = getImageListener();
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
    }

    private ImageListener getImageListener() {
        return new ImageListener() {
                @Override
                public void setImageForPosition(int position, ImageView imageView) {
                    imageView.setImageResource(sampleImages[position]);
                }
            };
    }


    private void getPromoProducts(){
        Call<List<Product>> call = api.getPromoProducts();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (!response.isSuccessful()) {
                    System.out.println(response.code());
                    return;
                }
                ArrayList<Product> promoSection= (ArrayList<Product>) response.body();
                ProductAdapter promoAdapter = new ProductAdapter(MainActivity.this, promoSection);
                GridView promoProducts = (GridView) findViewById(R.id.promo_products);
                promoProducts.setAdapter(promoAdapter);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
