package com.pika.Onlinegrocerystore.Services.ServiceImpl;

import com.pika.Onlinegrocerystore.Services.CustomerService;
import com.pika.Onlinegrocerystore.dao.ICustomerDao;
import com.pika.Onlinegrocerystore.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private final ICustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @Override
    public Customer findById(Long id) {
        Customer customer = customerDao.findCustomerById(id);
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void create(Customer customer) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Customer> findByName(String name) {
        return null;
    }

    @Override
    public Customer checkLogin(String name, String password) {
        return null;
    }
}
