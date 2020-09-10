package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.domain.ItemPair;
import com.pika.Onlinegrocerystore.domain.Order;
import com.pika.Onlinegrocerystore.domain.OrderItemPair;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.User;

import java.util.Date;
import java.util.List;

public interface IOrderDao {

    //for manager only
    List<Order> findAll();

    List<OrderItemPair> findItemsByOrderId(Long orderId);

    void addItemToOrder(@Param("orderId") Long orderId, @Param("productId")Long productId,@Param("quantity") int quantity);

    void updateOrder(Order order);

    void saveOrder(Order order);

    Order findOrderById(Long id);

    List<Order> findOrderByUserId(Long userId);

    List<Order> findOrderByDate(Date date);

    List<Order> findOrderByUserName(String userName);

    void deleteOrderById(Long orderId);

    void deleteItemsById(Long orderId);

    void deleteOrderByUserName(String userName);



//    /**
//     * fuzzy query 模糊查询
//     * @param username keyword order may contain 订单包含的关键字
//     */
//    List<Order> findOrderByName(String username);

    //    void updateOrder(Order order);

    //    void deleteOrder(Order order);
}
