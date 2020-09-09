package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.domain.Product;
import com.pika.Onlinegrocerystore.domain.Product;
import com.pika.Onlinegrocerystore.domain.PurchasePoint;

import java.util.List;

public interface IProductDao {
    List<Product> findAll();

    void saveProduct(Product product);

    void updateProduct(Product product);

    Product findProductById(Long id);

    List<Product> findProductByCategory(int categoryId);

    List<Product> findProductByName(String username);

    void deleteProductById(Long id);

    void deleteProductByName(String username);



}
