package com.pika.Onlinegrocerystore.dao;

import com.pika.Onlinegrocerystore.dao.IManagerDao;
import com.pika.Onlinegrocerystore.domain.Manager;
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
import static org.junit.Assert.*;

import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest(classes={com.pika.Onlinegrocerystore.dao.IManagerDao.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ManagerDaoTests {
    private IManagerDao managerDao;

    @BeforeAll
    public void init() throws Exception{
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
        //for(Manager manager:  managers) printALlInfo(manager);
        assertNotEquals(0, managers.size());
    }

    @Test
    public void testFindManagerById() throws Exception{
        Manager manager = managerDao.findManagerById(1L);
        //printALlInfo(manager);
        assertEquals(1L, (long)manager.getId());
    }

    @Test
    public void testFindManagerByName() throws Exception{
        List<Manager> managers = managerDao.findManagerByName("%userName1%");
        //for(Manager manager:  managers) printALlInfo(manager);
        assertNotNull(managers);
    }

    @Test
    public void testSaveUser() throws Exception{
        Manager manager = new Manager("UniqueName", "testSaveUser", "example@outlook.com",
                "1");

        managerDao.saveManager(manager);
        List<Manager> getByName = managerDao.findManagerByName("UniqueName");

        for(Manager m : getByName)
            assertEquals("UniqueName", m.getUsername());
    }

    @Test
    public void testUpdateManager() throws Exception{
        Random random = new Random();
        int randomValue = random.nextInt(Integer.MAX_VALUE);
        Manager manager = new Manager(3L, "good", "userName", randomValue + "@outlook.com",
                "1");
        managerDao.updateManager(manager);
        assertEquals(randomValue + "@outlook.com", managerDao.findManagerById(3L).getEmail());
    }

    @Test
    public void testDeleteManagerById() throws Exception{
        managerDao.deleteManagerById(2L);
        assertNull(managerDao.findManagerById(2L));
    }

}

