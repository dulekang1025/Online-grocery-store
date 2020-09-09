package com.pika.Onlinegrocerystore.Services;

import com.pika.Onlinegrocerystore.domain.Cart;
import com.pika.Onlinegrocerystore.domain.Customer;
import com.pika.Onlinegrocerystore.domain.ItemPair;
import com.pika.Onlinegrocerystore.domain.Product;

import java.util.List;

public interface CartService {
    void addItem(Long cartId, Long productId);
    void deleteItem(Long cartId, Long productId);
    List<ItemPair> getAllItems(Long cartId);

    double getTotalPrice(Long cartId);
    void clearCart(Long cartId);
}
