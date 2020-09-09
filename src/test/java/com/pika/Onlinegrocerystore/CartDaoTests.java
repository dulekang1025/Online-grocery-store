package com.pika.Onlinegrocerystore;

import com.pika.Onlinegrocerystore.dao.ICartDao;
import com.pika.Onlinegrocerystore.dao.ICustomerDao;
import com.pika.Onlinegrocerystore.domain.Cart;
import com.pika.Onlinegrocerystore.domain.ItemPair;
import com.pika.Onlinegrocerystore.domain.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;

@SpringBootTest(classes={com.pika.Onlinegrocerystore.dao.ICartDao.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CartDaoTests {
    private InputStream in;
    private ICartDao cartDao;
    private SqlSession sqlSession;

    @BeforeAll
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        cartDao = sqlSession.getMapper(ICartDao.class);
        System.out.println(in);
    }

    @AfterAll//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        // 提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
        // 关闭输入流
        in.close();
    }

    @Test
    public void findAllTest(){
        List<Cart> carts = cartDao.findAll();
//        for(Cart cart : carts){
//            System.out.println(cart.getCartId());
//        }
        assertNotEquals(0, carts.size());
    }

    @Test
    public void deleteCartByIdTest(){
        cartDao.deleteCartById(2L);
        assertNull(cartDao.findCartById(2L));
    }

    @Test
    public void saveCartTest(){
        Cart cart = new Cart(5L, 3L, 666.66);
        cartDao.saveCart(cart);
        Cart getCart = cartDao.findCartById(5L);
        assertEquals(5, (long)getCart.getCartId());
        cartDao.deleteCartById(5L);
    }

    @Test
    public void addItemByIdTest(){
        ItemPair newItemPair = new ItemPair(1L, 2L, 1);
        cartDao.addItemPair(newItemPair);
        List<ItemPair> itemPairs = cartDao.findAllCartItems(1L);
        int num = 0;
        for(ItemPair itemPair : itemPairs){
            if(itemPair.getProductId().equals(2L)){
                num += itemPair.getQuantity();
            }
        }
        cartDao.addItemById(1L, 2L);
        List<ItemPair> itemPairs2 = cartDao.findAllCartItems(1L);
        int num2 = 0;
        for(ItemPair itemPair : itemPairs2){
            if(itemPair.getProductId().equals(2L)){
                num2 += itemPair.getQuantity();
            }
        }
        assertEquals(num + 1, num2);
    }

    @Test
    public void deleteItemByIdTest(){
        List<ItemPair> itemPairs = cartDao.findAllCartItems(1L);
        int num = 0;
        for(ItemPair itemPair : itemPairs){
            if(itemPair.getProductId().equals(2L)){
                num += itemPair.getQuantity();
            }
        }
        cartDao.deleteItemById(1L, 2L);
        List<ItemPair> itemPairs2 = cartDao.findAllCartItems(1L);
        int num2 = 0;
        for(ItemPair itemPair : itemPairs2){
            if(itemPair.getProductId().equals(2L)){
                num2 += itemPair.getQuantity();
            }
        }
        assertEquals(num - 1, num2);
    }

    @Test
    public void addItemPairTest(){
        ItemPair itemPair = new ItemPair(1L, 4L, 1);
        cartDao.addItemPair(itemPair);
        assertEquals(1, cartDao.checkItemById(1L, 4L).getQuantity());
    }
    @Test
    public void checkItemByIdTest(){
        ItemPair itemPair = cartDao.checkItemById(1L, 4L);
        assertNotNull(itemPair);
        ItemPair notExistItemPair = cartDao.checkItemById(1L, 100L);
        assertNull(notExistItemPair);
        cartDao.clearCart(1L);
    }
    @Test
    public void findAllCartItemsTest(){
        ItemPair itemPair1 = new ItemPair(3L, 20L, 1);
        cartDao.addItemPair(itemPair1);
        ItemPair itemPair2 = new ItemPair(3L, 18L, 1);
        cartDao.addItemPair(itemPair2);
        ItemPair itemPair3 = new ItemPair(3L, 16L, 1);
        cartDao.addItemPair(itemPair3);
        List<ItemPair> itemPairs = cartDao.findAllCartItems(3L);
        assertEquals(3, itemPairs.size());
        cartDao.clearCart(3L);
    }

    @Test
    public void clearCartTest(){
        ItemPair itemPair1 = new ItemPair(3L, 20L, 1);
        cartDao.addItemPair(itemPair1);
        ItemPair itemPair2 = new ItemPair(3L, 18L, 1);
        cartDao.addItemPair(itemPair2);
        ItemPair itemPair3 = new ItemPair(3L, 16L, 1);
        cartDao.addItemPair(itemPair3);
        cartDao.clearCart(3L);
        List<ItemPair> itemPairs = cartDao.findAllCartItems(3L);
        assertEquals(0, itemPairs.size());
    }

    @Test
    public void findCartByIdTest(){
        Cart cart = cartDao.findCartById(1L);
        assertEquals(1, (long)cart.getCartId());
    }
}
