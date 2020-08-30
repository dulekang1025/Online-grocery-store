package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.domain.Order;

import java.util.List;

public interface IOrderDao {
    List<Order> findAll();

}
