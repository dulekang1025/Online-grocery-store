package com.pika.Onlinegrocerystore;

import com.pika.Onlinegrocerystore.dao.ICustomerDao;
import com.pika.Onlinegrocerystore.domain.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.List;

@SpringBootTest
class OnlineGroceryStoreApplicationTests {
//	private InputStream in;
//	private ICustomerDao customerDao;
//	private SqlSession sqlSession;
//	private ITestDao testDao;
//
//
////	@Override
//	public void beforeAll(ExtensionContext context) throws Exception {
//		System.out.println("beforeAll");
//		in = Resources.getResourceAsStream("SqlMapConfig.xml");
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//		sqlSession = factory.openSession(true);
//		testDao = sqlSession.getMapper(ITestDao.class);
//	}
//
//	public void init() throws Exception{
//		in = Resources.getResourceAsStream("SqlMapConfig.xml");
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//		sqlSession = factory.openSession(true);
//		testDao = sqlSession.getMapper(ITestDao.class);
//	}

//	@After
//	public void destroy() throws Exception{
//		sqlSession.close();
//		in.close();
//
//	}


//	@org.junit.jupiter.api.Test
//	public void testSout(){
//		System.out.println("all good");
//	}

	@org.junit.jupiter.api.Test
	public void testFindAllCustomer() throws Exception{
		InputStream in;
		ICustomerDao cdao;
		SqlSession sqlSession;
		in = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		sqlSession = factory.openSession(true);
		cdao = sqlSession.getMapper(ICustomerDao.class);
		System.out.println(in);
		List<Customer> customers = cdao.findAll();
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
