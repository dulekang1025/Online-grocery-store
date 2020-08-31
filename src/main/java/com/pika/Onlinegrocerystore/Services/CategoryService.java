package com.pika.Onlinegrocerystore.Services;

import com.pika.Onlinegrocerystore.domain.Category;

import java.util.List;

public interface CategoryService {
    Category findById(Long id);
    List<Category> findAll();
    void update(Category customer);
    void create(Category customer);
    void deleteById(Long id);
    void deleteByName(Long id);
    List<Category> findByName(String name);
}
