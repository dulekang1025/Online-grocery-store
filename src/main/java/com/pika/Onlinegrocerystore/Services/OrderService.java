package com.pika.Onlinegrocerystore.Services;

import com.pika.Onlinegrocerystore.domain.ItemPair;
import com.pika.Onlinegrocerystore.domain.Order;

import java.sql.Date;
import java.util.List;

public interface OrderService {

    //for manager
    List<Order> findAll();

    //for manager
    List<Order> findOrdersByDate(Date date);

    void updateOrder(Order order);

    void createOrder(Order order);

    Order findOrderById(Long orderId);

    List<Order> findOrdersByUserId(Long userId);

    void deleteOrderById(Long orderId);

    // change the order status, but not delete from database
    void deleteByUserName(String userName);

}
