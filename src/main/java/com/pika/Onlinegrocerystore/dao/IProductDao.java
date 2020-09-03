package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.domain.Category;
import com.pika.Onlinegrocerystore.domain.Product;

import java.util.List;

public interface IProductDao {
    Product findProductById(Long id);
    List<Product> findAll();
    void updateProduct(Product product);
    void saveProduct(Product product);
    void deleteProductById(Long id);
    //void deleteByName(int id);
    List<Product> findProductByName(String name);
    List<Product> findProductByCategory(Category category);
}
