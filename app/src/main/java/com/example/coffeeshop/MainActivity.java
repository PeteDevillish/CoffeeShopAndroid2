package com.example.coffeeshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

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


        promoSection.add(new Product((float) 4.0, "https://source.unsplash.com/random", "Big Brazil Coffee", 22.0, 30.0));
        promoSection.add(new Product((float) 3.5, "https://source.unsplash.com/random", "Small Brazil Coffee", 17.0, 23.0));

        ProductAdapter promoAdapter = new ProductAdapter(MainActivity.this, promoSection);

        GridView promoProducts = (GridView) findViewById(R.id.promo_products);

        promoProducts.setAdapter(promoAdapter);
    }



    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };


}
