package com.pika.Onlinegrocerystore.Services.ServiceImpl;

import com.pika.Onlinegrocerystore.Services.CartService;
import com.pika.Onlinegrocerystore.dao.ICartDao;
import com.pika.Onlinegrocerystore.dao.ICustomerDao;
import com.pika.Onlinegrocerystore.dao.IOrderDao;
import com.pika.Onlinegrocerystore.dao.IProductDao;
import com.pika.Onlinegrocerystore.domain.Cart;
import com.pika.Onlinegrocerystore.domain.Customer;
import com.pika.Onlinegrocerystore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private final ICartDao cartDao;
    private Double totalPrice;

    @Autowired
    public CartServiceImpl(ICartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Override
    public void addItem (Long productId){
        cartDao.addItemById(productId);
    }

    @Override
    public void deleteItem (Long productId){
        cartDao.deleteItemById(productId);
    }

    @Override
    public List<Product> getAllItems(){
        return cartDao.findAll();
    }

    @Override
    public double getTotalPrice(){
        return cartDao.calculateTotalPrice();
    }

    @Override
    public void clearCart(){
        cartDao.clearCart();
    }



}
