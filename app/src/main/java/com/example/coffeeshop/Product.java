package com.example.coffeeshop;


import java.math.BigDecimal;

public class Product {

    private Long id;
    private float rating;
    private String path;
    private String nameOfProduct;
    private BigDecimal price;
    private Category category;
    private BigDecimal promoPrice;
    private Long numberOfSoldProducts;
    private Long numberOfProductsInStock;

    public Product(Long id, float rating, String path, String nameOfProduct, BigDecimal price,
                   Category category, BigDecimal promoPrice, Long numberOfSoldProducts, Long numberOfProductsInStock) {
        this.id = id;
        this.rating = rating;
        this.path = path;
        this.nameOfProduct = nameOfProduct;
        this.price = price;
        this.category = category;
        this.promoPrice = promoPrice;
        this.numberOfSoldProducts = numberOfSoldProducts;
        this.numberOfProductsInStock = numberOfProductsInStock;
    }

    public float getRating() {
        return rating;
    }

    public String getPath() {
        return path;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
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
                ", Rating=" + rating +
                ", Path='" + path + '\'' +
                ", NameOfProduct='" + nameOfProduct + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", promoPrice=" + promoPrice +
                ", numberOfSoldProducts=" + numberOfSoldProducts +
                ", numberOfProductsInStock=" + numberOfProductsInStock +
                '}';
    }
}
