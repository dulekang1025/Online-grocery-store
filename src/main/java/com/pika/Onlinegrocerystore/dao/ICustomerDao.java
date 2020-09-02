package com.pika.Onlinegrocerystore.dao;



import com.pika.Onlinegrocerystore.domain.Customer;
import com.pika.Onlinegrocerystore.domain.CustomerQueryVo;
import com.pika.Onlinegrocerystore.domain.PurchasePoint;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface ICustomerDao {

    List<Customer> findAll();

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    Customer findCustomerById(Long userId);

    List<Customer> findCustomerByName(String username);

    void deleteCustomerById(Long userId);

    void deleteCustomerByName(String username);

    void addPointsToCustomerByID(PurchasePoint purchasePoint);

//    List<Customer> findCustomerByVo(CustomerQueryVo vo);
}
