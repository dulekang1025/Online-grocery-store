package com.pika.Onlinegrocerystore.Services.ServiceImpl;

import com.pika.Onlinegrocerystore.Services.OrderService;
import com.pika.Onlinegrocerystore.dao.IOrderDao;
import com.pika.Onlinegrocerystore.domain.Order;
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
    public Order findById(Long id) {
        Order order=orderDao.findOrderById(id);
        return order;
    }

    @Override
    public List<Order> findAll() {
        List<Order> result=orderDao.findAll();
        return result;
    }

    @Override
    public void update(Order order) {
        orderDao.updateOrder(order);
    }

    @Override
    public void create(Order order) {
        orderDao.saveOrder(order);
    }

    @Override
    public void deleteById(Long id) { //todo: impl by controller
//        orderDao.deleteOrder(id);
    }

    @Override
    public void deleteByUserName(String userName) {
        //todo: impl by controller

    }

    @Override
    public List<Order> findByUserId(Long id) {
        List<Order> result=orderDao.findOrderByUserId(id);
        return result;
    }

    @Override
    public List<Order> findByDate(Date date) {
        List<Order> result=orderDao.findOrderByDate(date);
        return result;
    }
}
