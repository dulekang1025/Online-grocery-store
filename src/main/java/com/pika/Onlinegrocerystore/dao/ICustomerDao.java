package com.pika.Onlinegrocerystore.dao;



import com.pika.Onlinegrocerystore.domain.Customer;
import com.pika.Onlinegrocerystore.domain.CustomerQueryVo;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface ICustomerDao {

    List<Customer> findAll();

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    Customer findCustomerById(Long userId);

    List<Customer> findCustomerByName(String username);

    List<Customer> findCustomerByVo(CustomerQueryVo vo);
}
