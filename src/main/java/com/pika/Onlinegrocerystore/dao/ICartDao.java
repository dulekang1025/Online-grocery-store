package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICartDao {

    // for manager only
    // find all carts in cartTable
    List<Cart> findAll();

    // find all items of a cart from cartItems table
    List<ItemPair> findAllCartItems(Long cartId);

    // before call this function, call checkItemById() first, if return object is NOT null,
    // then it is safe to use this function. Otherwise call  addItemPair() to add new record into cartItems table.
    // update quality when (cart_id, product_id) pair exist in cartItem table
    void addItemById(@Param("cartId")Long cartId, @Param("itemId") Long itemId);

    // decrease quality in cartItems table by 1.
    void deleteItemById(@Param("cartId")Long cartId, @Param("itemId") Long itemId);

    double calculateTotalPrice(@Param("cartId")Long cartId);

    // delete all record with give cart_id.
    void clearCart(Long cartId);

    // save cart to cartTable
    void saveCart(Cart cart);

    // get cart by id from cartTable
    Cart findCartById(Long cartId);

    // delete cart by if from cartTable
    void deleteCartById(Long cartId);

    // before call this function, call checkItemById() first, if return object is null,
    // then it is safe to use this function. Otherwise call  addItemById to update record in cartItems table.
    void addItemPair(ItemPair itemPair);

    // get ItemPair object if gaven (cart_id,item_id) exist in cartItems table as key.
    ItemPair checkItemById(@Param("cartId")Long cartId, @Param("itemId") Long itemId);

}

