package com.pika.Onlinegrocerystore.Services;

import com.pika.Onlinegrocerystore.dao.IManagerDao;
import com.pika.Onlinegrocerystore.domain.Manager;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

@SpringBootTest(classes={ManagerService.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ManagerServiceTests {
    private IManagerDao managerDao;

    @BeforeAll
    public void init() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.managerDao = ac.getBean(IManagerDao.class);
    }

    public static void printALlInfo(Manager manager){
        System.out.print(manager.getId() + '\t');
        System.out.print(manager.getUsername() + '\t');
        System.out.print(manager.getPassword() + '\t');
        System.out.print(manager.getEmail() + '\t');
        System.out.println(manager.getRole() + '\t');
    }

    @Test
    public void testFindAllManager() throws Exception{
        List<Manager> managers = managerDao.findAll();
        for(Manager manager:  managers) printALlInfo(manager);
//        assertNotEquals(0, managers.size());
    }
}
