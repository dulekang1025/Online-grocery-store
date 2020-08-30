package com.pika.Onlinegrocerystore.Services;

import com.pika.Onlinegrocerystore.domain.Order;

import java.util.List;

public interface OrderService {
    Order findById(int id);
    List<Order> findAll();
    void update(Order customer);
    void create(Order customer);
    void deleteById(int id);
    void deleteByName(int id);
    List<Order> findByName(String name);
}
