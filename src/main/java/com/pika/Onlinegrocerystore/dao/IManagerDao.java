package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.domain.Customer;
import com.pika.Onlinegrocerystore.domain.QueryVo;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface IManagerDao {
    List<Customer> findAll();

    void saveUser(Customer customer);

    void updateUser(Customer customer);

    void deleteUser(Customer customer);

    User findById(Integer userId);

    List<Customer> findByName(String username);

    List<Customer> findUserByVo(QueryVo vo);
}
