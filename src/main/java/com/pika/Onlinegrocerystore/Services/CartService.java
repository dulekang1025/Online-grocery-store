package com.pika.Onlinegrocerystore.Services;

import com.pika.Onlinegrocerystore.domain.Cart;
import com.pika.Onlinegrocerystore.domain.Product;

import java.util.List;

public interface CartService {
    void addItem(Long userId);
    void deleteItem(Long cartID);
    List<Product> getAllItems(Long userId);
    double getTotalPrice();
    void clearCart(Long userId);
}
