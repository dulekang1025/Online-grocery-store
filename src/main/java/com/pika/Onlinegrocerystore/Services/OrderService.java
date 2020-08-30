package com.pika.Onlinegrocerystore.Services;

import com.pika.Onlinegrocerystore.domain.Order;

import java.util.List;

public interface OrderService {
    Order findById(Long id);
    List<Order> findAll();
    void update(Order customer);
    void create(Order customer);
    void deleteById(Long id);
    void deleteByName(Long id);
    List<Order> findByName(String name);
}
