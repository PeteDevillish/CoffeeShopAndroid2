package com.example.coffeeshop;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {

    public ProductAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item, parent, false);
        }

        Product product = getItem(position);

        RatingBar ratingBar = (RatingBar) listItemView.findViewById(R.id.ratingBar);
        ratingBar.setRating(product.getRating());

        ImageView imageOfProduct = (ImageView) listItemView.findViewById(R.id.image_of_product);
        Picasso.get().load(product.getPath()).into(imageOfProduct);

        TextView name = (TextView) listItemView.findViewById(R.id.name);
        name.setText(product.getNameOfProduct());

        if (product.getPromoPrice() != null){
        TextView promoPrice = (TextView) listItemView.findViewById(R.id.promo_price);
        promoPrice.setText(product.getPromoPrice() + " PLN");
        promoPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }

        TextView regularPrice = (TextView) listItemView.findViewById(R.id.regular_price);
        regularPrice.setText(product.getPrice() + " PLN");

        return listItemView;
    }


}
