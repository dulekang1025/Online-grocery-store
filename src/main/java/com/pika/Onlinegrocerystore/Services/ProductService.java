package com.pika.Onlinegrocerystore.Services;

import com.pika.Onlinegrocerystore.domain.Category;
import com.pika.Onlinegrocerystore.domain.Product;

import java.util.List;

public interface ProductService {
    Product findById(Long id);
    List<Product> findAll();
    void update(Product product);
    void create(Product product);
    void deleteById(Long id);
    //void deleteByName(int id);
    List<Product> findByName(String name);
    List<Product> findByCategory(Category category);
}
