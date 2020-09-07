package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.domain.Order;
import org.springframework.security.core.userdetails.User;

import java.util.Date;
import java.util.List;

public interface IOrderDao {

    List<Order> findAll();
    
    void saveOrder(Order order);

    Order findOrderById(Long id);

    List<Order> findOrderByUserId(Long userId);

    List<Order> findOrderByDate(Date date);

    //do not delete from database, just change order status
//    void deleteOrder(Long id);

    void updateOrder(Order order);




//    /**
//     * fuzzy query 模糊查询
//     * @param username keyword order may contain 订单包含的关键字
//     */
//    List<Order> findOrderByName(String username);

    //    void updateOrder(Order order);

    //    void deleteOrder(Order order);
}
