package com.pika.Onlinegrocerystore.Services;

import com.pika.Onlinegrocerystore.domain.Order;

import java.sql.Date;
import java.util.List;

public interface OrderService {

    Order findById(Long id);
    List<Order> findAll();
    void update(Long id);
    void create(Order order);
    void deleteById(Long id);


    // change the order status, but not delete from database
    void deleteByUserName(String userName);

    List<Order> findByUserId(Long id);

    List<Order> findByDate(Date date);
}
