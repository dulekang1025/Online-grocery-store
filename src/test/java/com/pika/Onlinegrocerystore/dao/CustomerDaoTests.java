//package com.pika.Onlinegrocerystore.dao;
//
//import com.pika.Onlinegrocerystore.dao.ICustomerDao;
//import com.pika.Onlinegrocerystore.domain.Customer;
//import com.pika.Onlinegrocerystore.domain.CustomerQueryVo;
//import com.pika.Onlinegrocerystore.domain.PurchasePoint;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.jupiter.api.*;
//import org.springframework.boot.test.context.SpringBootTest;
//import java.io.InputStream;
//import java.sql.Date;
//import java.util.List;
//import java.util.Random;
//
//import org.junit.jupiter.api.TestInstance;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import static org.junit.Assert.*;
//
//
//@SpringBootTest(classes={com.pika.Onlinegrocerystore.dao.ICustomerDao.class})
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class CustomerDaoTests {
//    private InputStream in;
//    private ICustomerDao customerDao;
//    private SqlSession sqlSession;
//
//    @BeforeAll
//    public void init() throws Exception{
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        this.customerDao = ac.getBean(ICustomerDao.class);
////        in = Resources.getResourceAsStream("SqlMapConfig.xml");
////        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
////        sqlSession = factory.openSession(true);
////        customerDao = sqlSession.getMapper(ICustomerDao.class);
////        System.out.println(in);
//    }
//
////    @AfterAll//用于在测试方法执行之后执行
////    public void destroy()throws Exception{
////        // 提交事务
////        sqlSession.commit();
////        // 释放资源
////        sqlSession.close();
////        // 关闭输入流
////        in.close();
////    }
//
//    public static void printALlInfo(Customer customer){
//        System.out.print(customer.getId() + '\t');
//        System.out.print(customer.getUsername() + '\t');
//        System.out.print(customer.getPassword() + '\t');
//        System.out.print(customer.getEmail() + '\t');
//        System.out.print(customer.getRole() + '\t');
//        System.out.print(customer.getBirthday());
//        System.out.print('\t');
//        System.out.print(customer.getPhoneNum() + '\t');
//        System.out.println(customer.getPoints() + '\t');
//    }
//
//    @Test
//    public void testFindAllCustomer() throws Exception{
//        List<Customer> customers = customerDao.findAll();
////        for(Customer customer:  customers) printALlInfo(customer);
//        assertNotEquals(0, customers.size());
//    }
//
//    @Test
//    public void testFindCustomerById() throws Exception{
//        Customer customer = customerDao.findCustomerById(1L);
//        //printALlInfo(customer);
//        assertEquals(1L, (long)customer.getId());
//    }
//
//    @Test
//    public void testFindCustomerByName() throws Exception{
//        List<Customer> customers = customerDao.findCustomerByName("%userName1%");
//        //for(Customer customer:  customers) printALlInfo(customer);
//        assertNotNull(customers);
//    }
//
//    @Test
//    public void testSaveUser() throws Exception{
//        Customer customer = new Customer("UniqueName", "testSaveUser", "example@outlook.com",
//                "1", new Date(2015, 02, 11), "13911112345");
//
//        customerDao.saveCustomer(customer);
//
//        List<Customer> getByName = customerDao.findCustomerByName("UniqueName");
//
//        for(Customer c:  getByName)
//            assertEquals("UniqueName", c.getUsername());
//    }
//
//    @Test
//    public void testUpdateCustomer() throws Exception{
//        Random random = new Random();
//        int randomValue = random.nextInt(Integer.MAX_VALUE);
//        Customer customer = new Customer(3L, "good", "userName", "example3@outlook.com",
//                "1", new Date(2015, 02, 11), Integer.toString(randomValue));
//        customerDao.updateCustomer(customer);
//        assertEquals(Integer.toString(randomValue), customerDao.findCustomerById(3L).getPhoneNum());
//    }
//
//    @Test
//    public void testDeleteCustomerById() throws Exception{
//        customerDao.deleteCustomerById(2L);
//        Customer customer = customerDao.findCustomerById(2L);
//        assertNull(customer);
//    }
//
//    @Test
//    public void testDeleteCustomerByName() throws Exception{
//        customerDao.deleteCustomerByName("UniqueName");
//        List<Customer> getByName = customerDao.findCustomerByName("UniqueName");
//        assertEquals(0, getByName.size());
//    }
//
//    @Test void testAddPointsToCustomerById() throws Exception{
//        int prevPoints = customerDao.findCustomerById(5L).getPoints();
//        customerDao.addPointsToCustomerByID(new PurchasePoint(5L, 6666));
//        int curPoints = customerDao.findCustomerById(5L).getPoints();
//        assertEquals(6666, curPoints - prevPoints);
//    }
//
////    List<Customer> findCustomerByVo(CustomerQueryVo vo);
//
//}
