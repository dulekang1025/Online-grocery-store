package com.pika.Onlinegrocerystore.Services;

import com.pika.Onlinegrocerystore.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer findById(int id);
    List<Customer> findAll();
    void update(Customer customer);
    void create(Customer customer);
    void deleteById(int id);
    List<Customer> findByName(String name);
    Customer checkLogin(String name, String password);
}
