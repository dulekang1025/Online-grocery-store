package com.pika.Onlinegrocerystore.Services;

import com.pika.Onlinegrocerystore.domain.Manager;

import java.util.List;

public interface ManagerService {
    Manager findById(Long id);
    List<Manager> findAll();
    void update(Manager manager);
    void create(Manager manager);
    void deleteById(Long id);
    List<Manager> findByName(String name);
    Manager checkLogin(String name, String password);
}
