//package com.pika.Onlinegrocerystore.Services.ServiceImpl;
//
//import com.pika.Onlinegrocerystore.Services.CartService;
//import com.pika.Onlinegrocerystore.dao.ICartDao;
//import com.pika.Onlinegrocerystore.dao.ICustomerDao;
//import com.pika.Onlinegrocerystore.dao.IOrderDao;
//import com.pika.Onlinegrocerystore.dao.IProductDao;
//import com.pika.Onlinegrocerystore.domain.Cart;
//import com.pika.Onlinegrocerystore.domain.Customer;
//import com.pika.Onlinegrocerystore.domain.ItemPair;
//import com.pika.Onlinegrocerystore.domain.Product;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.lang.Object;
//import java.util.List;
//
//@Service
//@Transactional
//public class CartServiceImpl implements CartService {
//    private ICartDao cartDao;
//    private IProductDao productDao;
//
//    @Autowired
//    public CartServiceImpl() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        this.productDao = ac.getBean(IProductDao.class);
//        this.cartDao = ac.getBean(ICartDao.class);
//    }
//
//    @Override
//    public void addItem(Long cartId, Long productId) {
//        // first check if (carId, productId) exist in cartItems table
//        // if not exist, call insert function
//        // if exist, call update function
//        ItemPair itemPair = cartDao.checkItemById(cartId, productId);
//        if(itemPair == null){
//            ItemPair newItempair = new ItemPair(cartId, productId, 1);
//            cartDao.addItemPair(newItempair);
//        }else{
//            cartDao.addItemById(cartId, productId);
//        }
//    }
//
//    @Override
//    public void deleteItem(Long cartId, Long productId) {
//        cartDao.deleteItemById(cartId, productId);
//    }
//
//    @Override
//    public List<ItemPair> getAllItems(Long cartId) {
//        return cartDao.findAllCartItems(cartId);
//    }
//
//    @Override
//    public double getTotalPrice(Long cartId) {
//        double sum = 0.0;
//        List<ItemPair> items = cartDao.findAllCartItems(cartId);
//        System.out.println("price: " + '\t' + "quantity: ");
//        for(ItemPair ip: items){
//            double price = this.productDao.findProductById(ip.getProductId()).getPrice();
//            System.out.print(price + "\t\t");
//            System.out.println(ip.getQuantity());
//            sum += price * ip.getQuantity();
//        }
//        return sum;
//    }
//
//    @Override
//    public void clearCart(Long cartId) {
//        cartDao.clearCart(cartId);
//    }
//}
