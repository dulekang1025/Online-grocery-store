package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.domain.Order;
import org.springframework.security.core.userdetails.User;

import java.util.Date;
import java.util.List;

public interface IOrderDao {
    List<Order> findAll();

    void findOrderById(Long id);

    void deleteOrderById(Long id);

    Double getTotalPrice();
}