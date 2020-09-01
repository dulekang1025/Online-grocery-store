package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.domain.Order;
import org.springframework.security.core.userdetails.User;

import java.util.Date;
import java.util.List;

public interface IOrderDao {
    List<Order> findAll();
    
    void createOrder(Order order);

    Order findOrderById(Integer userId);

    List<Order> findOrderByDate(Date username);


//    /**
//     * fuzzy query 模糊查询
//     * @param username keyword order may contain 订单包含的关键字
//     */
//    List<Order> findOrderByName(String username);

    //    void updateOrder(Order order);

    //    void deleteOrder(Order order);
}
