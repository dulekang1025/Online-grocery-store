package com.pika.Onlinegrocerystore.Services;

import com.pika.Onlinegrocerystore.domain.Category;
import com.pika.Onlinegrocerystore.domain.Product;

import java.util.List;

public interface ProductService {
    Product findById(Long id);
    List<Product> findAll();
    void update(Product customer);
    void create(Product customer);
    void deleteById(Long id);
    //void deleteByName(int id);
    List<Product> findByName(String name);
    List<Product> findByCategory(Category category);
}
