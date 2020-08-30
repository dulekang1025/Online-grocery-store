package com.pika.Onlinegrocerystore.Services;

import com.pika.Onlinegrocerystore.domain.Category;

import java.util.List;

public interface CategoryService {
    Category findById(int id);
    List<Category> findAll();
    void update(Category customer);
    void create(Category customer);
    void deleteById(int id);
    void deleteByName(int id);
    List<Category> findByName(String name);
}
