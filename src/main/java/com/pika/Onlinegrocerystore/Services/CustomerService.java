package com.pika.Onlinegrocerystore.Services;

import com.pika.Onlinegrocerystore.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer findById(Long id);
    List<Customer> findAll();
    void update(Customer customer);
    void create(Customer customer);
    void deleteById(Long id);
    List<Customer> findByName(String name);
    Customer checkLogin(String name, String password);
}
