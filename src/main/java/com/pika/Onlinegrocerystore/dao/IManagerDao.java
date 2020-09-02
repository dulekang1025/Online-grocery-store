package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.domain.Customer;
import com.pika.Onlinegrocerystore.domain.Manager;
import com.pika.Onlinegrocerystore.domain.CustomerQueryVo;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface IManagerDao {
    List<Manager> findAll();

    void saveManager(Manager manager);

    void updateManager(Manager manager);

    Manager findManagerById(Long userId);

    void deleteManagerById(Long userId);

    List<Manager> findManagerByName(String username);

//    List<Customer> findManagerByVo(CustomerQueryVo vo);
}
