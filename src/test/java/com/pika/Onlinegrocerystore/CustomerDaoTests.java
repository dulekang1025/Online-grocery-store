package com.pika.Onlinegrocerystore;

import com.pika.Onlinegrocerystore.dao.ICustomerDao;
import com.pika.Onlinegrocerystore.domain.Customer;
import com.pika.Onlinegrocerystore.domain.CustomerQueryVo;
import com.pika.Onlinegrocerystore.domain.PurchasePoint;
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

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerDaoTests {
    private InputStream in;
    private ICustomerDao customerDao;
    private SqlSession sqlSession;

    @BeforeAll
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        customerDao = sqlSession.getMapper(ICustomerDao.class);
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

    public static void printALlInfo(Customer customer){
        System.out.print(customer.getId() + '\t');
        System.out.print(customer.getUsername() + '\t');
        System.out.print(customer.getPassword() + '\t');
        System.out.print(customer.getEmail() + '\t');
        System.out.print(customer.getRole() + '\t');
        System.out.print(customer.getBirthday());
        System.out.print('\t');
        System.out.print(customer.getPhoneNum() + '\t');
        System.out.println(customer.getPoints() + '\t');
    }

    @Test
    public void testFindAllCustomer() throws Exception{
        List<Customer> customers = customerDao.findAll();
        for(Customer customer:  customers) printALlInfo(customer);
    }

    @Test
    public void testFindCustomerById() throws Exception{
        Customer customer = customerDao.findCustomerById(1L);
        printALlInfo(customer);
    }

    @Test
    public void testFindCustomerByName() throws Exception{
        List<Customer> customers = customerDao.findCustomerByName("%userName1%");
        for(Customer customer:  customers) printALlInfo(customer);
    }

    @Test
    public void testSaveUser() throws Exception{
        Customer customer = new Customer("userName1", "testSaveUser", "example@outlook.com",
                "1", new Date(2015, 02, 11), "13911112345");

        customerDao.saveCustomer(customer);
    }

    @Test
    public void testUpdateCustomer() throws Exception{
        Random random = new Random();
        int randomValue = random.nextInt(Integer.MAX_VALUE);
        Customer customer = new Customer(3L, "good", "userName", "example3@outlook.com",
                "1", new Date(2015, 02, 11), Integer.toString(randomValue));
        customerDao.updateCustomer(customer);
    }

    @Test
    public void testDeleteCustomerById() throws Exception{
        customerDao.deleteCustomerById(2L);
    }

    @Test
    public void testDeleteCustomerByName() throws Exception{
        customerDao.deleteCustomerByName("%userName1%");
    }

    @Test void testAddPointsToCustomerById() throws Exception{
        customerDao.addPointsToCustomerByID(new PurchasePoint(1L, 5000));
    }

//    List<Customer> findCustomerByVo(CustomerQueryVo vo);

}