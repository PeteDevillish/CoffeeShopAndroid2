package com.example.coffeeshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CarouselView carouselView;

    int[] sampleImages = {R.drawable.image_1, R.drawable.image_2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);

        ArrayList<Product> promoSection= new ArrayList<Product>();

        promoSection.add(new Product(1L, (float) 4.0, "https://source.unsplash.com/random", "Big Brazil Coffee", BigDecimal.valueOf(22.0), null, null, null, null));
        promoSection.add(new Product(2L, (float) 3.5, "https://source.unsplash.com/random", "Small Brazil Coffee", BigDecimal.valueOf(17.0),null, BigDecimal.valueOf(23.0), null, null));

        ProductAdapter promoAdapter = new ProductAdapter(MainActivity.this, promoSection);

        GridView promoProducts = (GridView) findViewById(R.id.promo_products);

        promoProducts.setAdapter(promoAdapter);

        Button btn = (Button) findViewById(R.id.button0);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ProductActivity.class);
                startActivity(myIntent);
            }
        });
    }



    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };




}
