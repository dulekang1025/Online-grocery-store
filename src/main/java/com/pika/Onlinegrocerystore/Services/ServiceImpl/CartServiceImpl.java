package com.pika.Onlinegrocerystore.Services.ServiceImpl;

import com.pika.Onlinegrocerystore.Services.CartService;
import com.pika.Onlinegrocerystore.dao.ICartDao;
import com.pika.Onlinegrocerystore.dao.ICustomerDao;
import com.pika.Onlinegrocerystore.dao.IOrderDao;
import com.pika.Onlinegrocerystore.dao.IProductDao;
import com.pika.Onlinegrocerystore.domain.Cart;
import com.pika.Onlinegrocerystore.domain.Customer;
import com.pika.Onlinegrocerystore.domain.ItemPair;
import com.pika.Onlinegrocerystore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.Object;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private final ICartDao cartDao;
    private final IProductDao productDao;

    @Autowired
    public CartServiceImpl(ICartDao cartDao, IProductDao productDao) {
        this.productDao = productDao;
        this.cartDao = cartDao;
    }

    @Override
    public void addItem(Long cartId, Long productId) {
        cartDao.addItemById(cartId, productId);
    }

    @Override
    public void deleteItem(Long cartId, Long productId) {
        cartDao.deleteItemById(cartId, productId);
    }

    @Override
    public List<ItemPair> getAllItems(Long cartId) {
        return cartDao.findAllCartItems(cartId);
    }

    @Override
    public double getTotalPrice(Long cartId) {
        double sum = 0.0;
        List<ItemPair> items = cartDao.findAllCartItems(cartId);
        System.out.println("price: " + '\t' + "quantity: ");
        for(ItemPair ip: items){
            double price = this.productDao.findProductById(ip.getProductId()).getPrice();
            System.out.print(price + "\t\t");
            System.out.println(ip.getQuantity());
            sum += price * ip.getQuantity();
        }
        return sum;
    }

    @Override
    public void clearCart(Long cartId) {

    }
}
