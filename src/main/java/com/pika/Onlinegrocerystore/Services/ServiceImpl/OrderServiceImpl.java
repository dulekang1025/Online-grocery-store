package com.pika.Onlinegrocerystore.Services.ServiceImpl;

import com.pika.Onlinegrocerystore.Services.OrderService;
import com.pika.Onlinegrocerystore.dao.IOrderDao;
import com.pika.Onlinegrocerystore.domain.ItemPair;
import com.pika.Onlinegrocerystore.domain.Order;
import com.pika.Onlinegrocerystore.domain.OrderItemPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final IOrderDao orderDao;

    @Autowired
    public OrderServiceImpl (IOrderDao orderDao){
        this.orderDao=orderDao;
    }

    @Override
    public List<Order> findAll() {
        List<Order> result=orderDao.findAll();
        for(Order res:result){
            res.setOrderDetails(orderDao.findItemsByOrderId(res.getOrderId()));
        }
        return result;
    }

    @Override
    public void updateOrder(Order order) {

        orderDao.updateOrder(order);

        for(OrderItemPair item:order.getOrderDetails()){
            orderDao.addItemToOrder(order.getOrderId(),item.getProductId(),item.getQuantity());
        }

    }

    @Override
    public void createOrder(Order order) {

        orderDao.saveOrder(order);
        for(OrderItemPair item:order.getOrderDetails()){
            orderDao.addItemToOrder(order.getOrderId(),item.getProductId(),item.getQuantity());
        }
    }

    @Override
    public Order findOrderById(Long orderId) {
        Order order=orderDao.findOrderById(orderId);
        List<OrderItemPair> items=orderDao.findItemsByOrderId(orderId);
        order.setOrderDetails(items);
        return order;
    }

    @Override
    public List<Order> findOrdersByUserId(Long id) {
        List<Order> result=orderDao.findOrderByUserId(id);
        for(Order order:result){
            order.setOrderDetails(orderDao.findItemsByOrderId(order.getOrderId()));
        }
        return result;
    }

    @Override
    public List<Order> findOrdersByDate(Date date) {
        List<Order> result=orderDao.findOrderByDate(date);
        for(Order order:result){
            order.setOrderDetails(orderDao.findItemsByOrderId(order.getOrderId()));
        }
        return result;
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderDao.deleteOrderById(orderId);
        orderDao.deleteItemsById(orderId);
    }

    @Override
    public void deleteByUserName(String userName) {
        List<Order> orders=orderDao.findOrderByUserName(userName);

        for(Order ord:orders){
            orderDao.deleteItemsById(ord.getOrderId());
        }

        orderDao.deleteOrderByUserName(userName);

    }


}
