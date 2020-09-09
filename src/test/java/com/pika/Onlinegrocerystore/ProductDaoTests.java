package com.pika.Onlinegrocerystore;

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
import org.springframework.security.core.parameters.P;

import static org.junit.Assert.*;

@SpringBootTest(classes={com.pika.Onlinegrocerystore.dao.IProductDao.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductDaoTests {
    private InputStream in;
    private IProductDao productDao;
    private SqlSession sqlSession;

    @BeforeAll
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        productDao = sqlSession.getMapper(IProductDao.class);
        System.out.println(in);
    }

    @AfterAll//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        // 提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
        // 关闭输入流
        in.close();
    }

    @Test
    public void findAllTest(){
        List<Product> products = productDao.findAll();
        assertNotNull(products);
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
