package com.pika.Onlinegrocerystore;

import com.pika.Onlinegrocerystore.dao.ICustomerDao;
import com.pika.Onlinegrocerystore.domain.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OnlineGroceryStoreApplicationTests {
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


	@Test
	public void testFindAllCustomer() throws Exception{
		List<Customer> customers = customerDao.findAll();

		for (Customer cus: customers){
			System.out.println(cus.getId());
			System.out.println(cus.getUsername());
			System.out.println(cus.getPassword());
			System.out.println(cus.getEmail());
			System.out.println(cus.getRole());
			System.out.println(cus.getBirthday());
			System.out.println(cus.getPhoneNum());
			System.out.println(cus.getPoints());
		}
	}

	@Test
	public void testFindCustomerById() throws Exception{
		Customer customer = customerDao.findCustomerById(5L);
		System.out.println(customer.getId());
		System.out.println(customer.getUsername());
		System.out.println(customer.getEmail());
		System.out.println(customer.getPhoneNum());
		System.out.println(customer.getPoints());
	}

	@Test
	public void testSaveUser() throws Exception{
		Customer customer = new Customer("mypassword", "Chick",
				"chick@outlook.com", "1", new Date(2014, 02, 11),
				"139111456678", 999999);

		customerDao.saveCustomer(customer);
		System.out.println("save successfully");

	}

}
