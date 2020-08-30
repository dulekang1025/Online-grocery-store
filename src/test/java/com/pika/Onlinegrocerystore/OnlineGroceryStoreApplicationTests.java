package com.pika.Onlinegrocerystore;

import com.pika.Onlinegrocerystore.dao.ICustomerDao;
import com.pika.Onlinegrocerystore.domain.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.io.InputStream;
import java.util.List;

@SpringBootTest
class OnlineGroceryStoreApplicationTests {
	private InputStream in;
	private ICustomerDao customerDao;
	private SqlSession sqlSession;

	@Before
	public void init() throws Exception{
		in = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		sqlSession = factory.openSession(true);
		customerDao = sqlSession.getMapper(ICustomerDao.class);
	}

	@After
	public void destroy() throws Exception{
		sqlSession.close();
		in.close();
	}

	@Test
	public void testSout(){
		System.out.println("all good");
	}

	@Test
	public void testFindAllCustomer(){
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

}
