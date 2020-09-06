package com.pika.Onlinegrocerystore.Services;

import com.pika.Onlinegrocerystore.domain.Cart;
import com.pika.Onlinegrocerystore.domain.Customer;
import com.pika.Onlinegrocerystore.domain.Product;

import java.util.List;

public interface CartService {
    void addItem(Long productId);
    void deleteItem(Long productId);
    List<Product> getAllItems();
    double getTotalPrice();
    void clearCart();
}
