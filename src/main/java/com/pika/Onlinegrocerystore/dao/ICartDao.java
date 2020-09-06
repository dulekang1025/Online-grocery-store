package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.domain.Customer;
import com.pika.Onlinegrocerystore.domain.Product;
import com.pika.Onlinegrocerystore.domain.PurchasePoint;

import java.util.List;

public interface ICartDao {
    List<Product> findAll();

    void addItemById(Long userId);

    void deleteItemById(Long userId);

    double calculateTotalPrice();

    void clearCart();
}

