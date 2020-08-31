package com.pika.Onlinegrocerystore.Services;

import com.pika.Onlinegrocerystore.domain.Cart;
import com.pika.Onlinegrocerystore.domain.Product;

import java.util.List;

public interface CartService {
    Cart addCart(Long userId);
    Cart getCart(Long cartID);
    List<Product> getCartList(Long userId);
    void deleteCartItem(Long userId, Long itemId);
    void clearCartItem(Long userId);
}
