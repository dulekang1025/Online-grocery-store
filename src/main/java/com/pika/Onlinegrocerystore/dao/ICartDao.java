package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICartDao {

    //for manager only
    List<Cart> findAll();

    List<ItemPair> findAllCartItems(Long cartId);

    void addItemById(@Param("cartId")Long cartId, @Param("itemId") Long itemId);

    void deleteItemById(@Param("cartId")Long cartId, @Param("itemId") Long itemId);

    double calculateTotalPrice(@Param("cartId")Long cartId);

    void clearCart(Long cartId);

    void saveCart(Cart cart);

    Cart findCartById(Long cartId);

    void deleteCartById(Long cartId);

    void addItemPair(ItemPair itemPair);

    ItemPair checkItemById(@Param("cartId")Long cartId, @Param("itemId") Long itemId);

}

