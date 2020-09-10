package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.domain.Customer;
import com.pika.Onlinegrocerystore.domain.Order;
import com.pika.Onlinegrocerystore.domain.OrderItemPair;
import com.pika.Onlinegrocerystore.domain.OrderStatus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes={com.pika.Onlinegrocerystore.dao.IOrderDao.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IOrderDaoTest {
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
    void findAll() {
        List<Order> orders = orderDao.findAll();
        assertNotEquals(0, orders.size());
    }

    @Test
    void updateOrder() {
        Customer customer = new Customer("UniqueName", "testSaveUser", "example@outlook.com",
                "1", new Date(2015, 03, 11), "13911112345");
        List<OrderItemPair> list=new ArrayList<>();
//        OrderItemPair item=new OrderItemPair(1L,2L,11);
        Order order = new Order(2L, 1L,"UniqueName", "QC", "Montreal",
                "5000","H3H1P8", "5510290054716567",
                "0722","011",2000.00,new Date(2015, 10, 11),OrderStatus.Awaiting_Shipment,39,list);
        orderDao.saveOrder(order);
        order.setCity("Laval");
        System.out.println(order.getCity());
        orderDao.updateOrder(order);
        assertEquals("Laval", orderDao.findOrderById(order.getId()).getCity());
    }

    @Test
    void saveOrder() {
        Customer customer = new Customer("UniqueName", "testSaveUser", "example@outlook.com",
                "1", new Date(2015, 02, 11), "13911112345");

        List<OrderItemPair> list=new ArrayList<>();
        OrderItemPair orderItemPair=new OrderItemPair(1L,3L,10);
        list.add(orderItemPair);

        orderDao.addItemToOrder(1L,3L,10);

        Order order = new Order(1L, 1L,"UniqueName", "QC", "Montreal",
                "5000","H3H1P8", "5510290054716567",
                "0722","011",1000.00,new Date(2015, 02, 11), OrderStatus.Awaiting_Payment,520,list);

        orderDao.saveOrder(order);
        Order findOrder = orderDao.findOrderById(1L);
        assertEquals(1, (long)findOrder.getId());
        assertEquals("UniqueName", findOrder.getUserName());
        assertEquals(1000, (double)findOrder.getSumPrice(),0);
        assertEquals(10,orderDao.findItemsByOrderId(1L).get(0).getQuantity());
    }

    @Test
    void findOrderById() {
        Order findOrder = orderDao.findOrderById(1L);
        assertEquals(1, (long)findOrder.getId());

        assertEquals(2,orderDao.findItemsByOrderId(1L).size());
    }

    @Test
    void findOrderByUserId() {
        List<Order> orders = orderDao.findOrderByUserId(1L);
        for(Order order : orders){
            assertEquals(1, (long)order.getId());
            assertEquals(2,orderDao.findItemsByOrderId(order.getId()).size());
        }

    }

    @Test
    void findOrderByDate() {
        List<Order> orders = orderDao.findOrderByDate(new Date(2015, 02, 11));
        for(Order order : orders)
            assertEquals(new Date(2015, 02, 11), order.getCreateTime());
    }


    @Test
    void deleteOrderById() {
        orderDao.deleteItemsById(1L);
        orderDao.deleteOrderById(1L);
        assertEquals(0,orderDao.findItemsByOrderId(1L).size());
    }
    
}