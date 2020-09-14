package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.dao.IProductDao;
import com.pika.Onlinegrocerystore.domain.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.TestInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.parameters.P;

import static org.junit.Assert.*;

@SpringBootTest(classes={com.pika.Onlinegrocerystore.dao.IProductDao.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductDaoTests {
    private IProductDao productDao;

    @BeforeAll
    public void init() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.productDao = ac.getBean(IProductDao.class);
    }

    @Test
    public void findAllTest(){
        List<Product> products = productDao.findAll();
        assertNotEquals(0, products.size());
    }

    @Test
    public void saveProductTest(){
        Product product = new Product(2L,10,"Milk",
                3,5.00,"3% Lactose Free",
                null,1,new Date(2020,9,20));
        productDao.saveProduct(product);
        List<Product> products = productDao.findProductByName("Milk");
        for(Product p : products)
            assertEquals("Milk", p.getProductName());
    }

    @Test
    public void updateProductTest(){
        Product product = new Product(2L,100,"Mushroom",
                1,1.010,"White Mushroom",
                null,1,new Date(2020,9,20));
        productDao.updateProduct(product);

        assertEquals(100, productDao.findProductById(2L).getInStock());
    }

    @Test
    public void findProductByIdTest(){
        Product product = productDao.findProductById(2L);
        assertEquals(2L, (long)product.getId());
    }

    @Test
    public void findProductByNameTest(){
        List<Product> products = productDao.findProductByName("Mushroom");
        assertNotNull(products);
        for(Product product : products)
            assertEquals(product.getProductName(), "Mushroom");
    }

    @Test
    public void deleteProductByIdTest(){
        productDao.deleteProductById(1L);
        assertNull(productDao.findProductById(1L));
    }

    @Test
    public void deleteProductByNameTest(){
        productDao.deleteProductByName("Milk");
        List<Product> products = productDao.findProductByName("Milk");
        assertEquals(0, products.size());
    }
}
