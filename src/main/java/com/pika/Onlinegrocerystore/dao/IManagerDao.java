package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.domain.Customer;
import com.pika.Onlinegrocerystore.domain.Manager;
import com.pika.Onlinegrocerystore.domain.QueryVo;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface IManagerDao {
    List<Manager> findAll();

    void saveManager(Manager manager);

    void updateManager(Manager manager);

    void deleteManager(Manager manager);

    User findManagerById(Integer userId);

    List<Customer> findManagerByName(String username);

    List<Customer> findManagerByVo(QueryVo vo);
}