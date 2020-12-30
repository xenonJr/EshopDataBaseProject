package com.example.sqlitepractice.Models;

import java.util.List;

public class Order {
    List<Product> orderedProduct;
    User user;

    public Order(List<Product> orderedProduct, User user) {
        this.orderedProduct = orderedProduct;
        this.user = user;
    }

    public List<Product> getOrderedProduct() {
        return orderedProduct;
    }

    public void setOrderedProduct(List<Product> orderedProduct) {
        this.orderedProduct = orderedProduct;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
