package com.pika.Onlinegrocerystore.dao.impl;

import com.pika.Onlinegrocerystore.dao.ICustomerDao;
import com.pika.Onlinegrocerystore.domain.Customer;
import com.pika.Onlinegrocerystore.domain.QueryVo;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao {

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void saveCustomer(Customer customer) {

    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(Customer customer) {

    }

    @Override
    public User findCustomerById(Integer userId) {
        return null;
    }

    @Override
    public List<Customer> findCustomerByName(String username) {
        return null;
    }

    @Override
    public List<Customer> findCustomerByVo(QueryVo vo) {
        return null;
    }
}
