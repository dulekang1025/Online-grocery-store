package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.domain.Cart;
import com.pika.Onlinegrocerystore.domain.Customer;
import com.pika.Onlinegrocerystore.domain.PurchasePoint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICartDao {

    //for manager only
    List<Customer> findAll();

    void addItemById(@Param("cartId")Long cartId, @Param("itemId") Long itemId);

    void deleteItemById(@Param("cartId")Long cartId, @Param("itemId") Long itemId);

    double calculateTotalPrice(@Param("cartId")Long cartId);

    void clearCart(Long cartId);

    void saveCart(Cart cart);

}

