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
    public void saveUser(Customer customer) {

    }

    @Override
    public void updateUser(Customer customer) {

    }

    @Override
    public void deleteUser(Customer customer) {

    }

    @Override
    public User findById(Integer userId) {
        return null;
    }

    @Override
    public List<Customer> findByName(String username) {
        return null;
    }

    @Override
    public List<Customer> findUserByVo(QueryVo vo) {
        return null;
    }
}
