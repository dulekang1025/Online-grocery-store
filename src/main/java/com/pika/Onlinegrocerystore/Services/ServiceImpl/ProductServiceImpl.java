package com.pika.Onlinegrocerystore.Services.ServiceImpl;

import com.pika.Onlinegrocerystore.Services.ProductService;
import com.pika.Onlinegrocerystore.dao.ICartDao;
import com.pika.Onlinegrocerystore.dao.IProductDao;
import com.pika.Onlinegrocerystore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private IProductDao productDao;
    private Double totalPrice;


    @Override
    public Product findById(Long id) {
        return productDao.findProductById(id);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void update(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public void create(Product product) {
        productDao.saveProduct(product);
    }

    @Override
    public void deleteById(Long id) {
        productDao.deleteProductById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productDao.findProductByName(name);
    }

    @Override
    public List<Product> findByCategory(int categoryId) {
        return productDao.findProductByCategory(categoryId);
    }
}
