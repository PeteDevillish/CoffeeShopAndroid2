package com.example.coffeeshop;

import com.squareup.picasso.Picasso;

import java.math.BigDecimal;

public class Product {


    private Long id;
    private float Rating;
    private String Path;
    private String NameOfProduct;
    private BigDecimal price;
    private Category category;
    private BigDecimal promoPrice;
    private Long numberOfSoldProducts;
    private Long numberOfProductsInStock;

    public Product(Long id, float rating, String path, String nameOfProduct, BigDecimal price, Category category, BigDecimal promoPrice, Long numberOfSoldProducts, Long numberOfProductsInStock) {
        this.id = id;
        Rating = rating;
        Path = path;
        NameOfProduct = nameOfProduct;
        this.price = price;
        this.category = category;
        this.promoPrice = promoPrice;
        this.numberOfSoldProducts = numberOfSoldProducts;
        this.numberOfProductsInStock = numberOfProductsInStock;
    }

    public float getRating() {
        return Rating;
    }

    public String getPath() {
        return Path;
    }

    public String getNameOfProduct() {
        return NameOfProduct;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public BigDecimal getPromoPrice() {
        return promoPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", Rating=" + Rating +
                ", Path='" + Path + '\'' +
                ", NameOfProduct='" + NameOfProduct + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", promoPrice=" + promoPrice +
                ", numberOfSoldProducts=" + numberOfSoldProducts +
                ", numberOfProductsInStock=" + numberOfProductsInStock +
                '}';
    }
}
