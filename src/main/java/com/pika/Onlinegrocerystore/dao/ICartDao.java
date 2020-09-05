package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.domain.Customer;
import com.pika.Onlinegrocerystore.domain.PurchasePoint;

import java.util.List;

public interface ICartDao {
    List<Customer> findAll();

    void addProductById(Long userId);

    void deleteCustomerById(Long userId);

    double calculateTotalPrice();
}

