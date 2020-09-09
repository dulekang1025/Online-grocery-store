package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.dao.ICartDao;
import com.pika.Onlinegrocerystore.dao.ICustomerDao;
import com.pika.Onlinegrocerystore.dao.IOrderDao;
import com.pika.Onlinegrocerystore.domain.Customer;
import com.pika.Onlinegrocerystore.domain.Order;
import com.pika.Onlinegrocerystore.domain.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;

@SpringBootTest(classes={com.pika.Onlinegrocerystore.dao.IOrderDao.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderDaoTests {
    private InputStream in;
    private IOrderDao orderDao;
    private SqlSession sqlSession;

    @BeforeAll
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        orderDao = sqlSession.getMapper(IOrderDao.class);
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
        List<Order> orders = orderDao.findAll();
        assertNotEquals(0, orders.size());
    }


    @Test
    public void saveOrderTest(){
        Customer customer = new Customer("UniqueName", "testSaveUser", "example@outlook.com",
                "1", new Date(2015, 02, 11), "13911112345");
        Order order = new Order(1L, customer,"UniqueName", "QC", "Montreal",
                "5000","H3H1P8", "5510290054716567",
                "0722","011",1000.00,new Date(2015, 02, 11));
        orderDao.saveOrder(order);
        Order findOrder = orderDao.findOrderById(1L);
        assertEquals(1, (long)findOrder.getOrderId());
        assertEquals("UniqueName", findOrder.getName());
        assertEquals(1000.00, (double)findOrder.getSumPrice());
    }

    @Test
    public void testFindOrderById(){
        Order findOrder = orderDao.findOrderById(1L);
        assertEquals(1, (long)findOrder.getOrderId());
    }

    @Test
    public void testFindOrderByUserId(){
        List<Order> orders = orderDao.findOrderByUserId(1L);
        for(Order order : orders)
            assertEquals(1, (long)order.getOrderId());
    }

    @Test
    public void testFindOrderByDate(){
        List<Order> orders = orderDao.findOrderByDate(new Date(2015, 02, 11));
        for(Order order : orders)
            assertEquals(new Date(2015, 02, 11), order.getCreateTime());
    }

    @Test
    public void testUpdateOrder(){
        Customer customer = new Customer("UniqueName", "testSaveUser", "example@outlook.com",
                "1", new Date(2015, 03, 11), "13911112345");
        Order order = new Order(2L, customer,"UniqueName", "QC", "Montreal",
                "5000","H3H1P8", "5510290054716567",
                "0722","011",2000.00,new Date(2015, 10, 11));
        orderDao.saveOrder(order);
        order.setCity("Laval");
        orderDao.updateOrder(order);
        assertEquals("Laval", orderDao.findOrderById(2L).getCity());
    }
}
