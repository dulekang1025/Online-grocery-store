package com.pika.Onlinegrocerystore.dao.impl;

import com.pika.Onlinegrocerystore.dao.IManagerDao;
import com.pika.Onlinegrocerystore.domain.Customer;
import com.pika.Onlinegrocerystore.domain.Manager;
import com.pika.Onlinegrocerystore.domain.QueryVo;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class ManagerDao implements IManagerDao {
    @Override
    public List<Manager> findAll() {
        return null;
    }

    @Override
    public void saveManager(Manager manager) {

    }

    @Override
    public void updateManager(Manager manager) {

    }

    @Override
    public void deleteManager(Manager manager) {

    }

    @Override
    public User findManagerById(Integer userId) {
        return null;
    }

    @Override
    public List<Customer> findManagerByName(String username) {
        return null;
    }

    @Override
    public List<Customer> findManagerByVo(QueryVo vo) {
        return null;
    }
}
