package com.pika.Onlinegrocerystore.Services.ServiceImpl;

import com.pika.Onlinegrocerystore.Services.CustomerService;
import com.pika.Onlinegrocerystore.dao.ICustomerDao;
import com.pika.Onlinegrocerystore.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
    public class CustomerServiceImpl implements CustomerService {

    private ICustomerDao customerDao;

    @Autowired
//    may have problems, coz i closed error checking spring core: autowiring for bean class
    public CustomerServiceImpl(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    // elliott sept4
    public CustomerServiceImpl(String s) {

    }

    @Override
    public Customer findById(Long id) {
        Customer customer = customerDao.findCustomerById(id);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> result = customerDao.findAll();
        return null;
    }

    @Override
    public void update(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    @Override
    public void create(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerDao.deleteCustomerById(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> result = customerDao.findCustomerByName(name);
        return null;
    }

    @Override
    public Customer checkLogin(String name, String password) {
        //todo : check login
        return null;
    }
}
