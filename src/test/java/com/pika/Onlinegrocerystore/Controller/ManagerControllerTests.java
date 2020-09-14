


//It's not a good idea to use this file to test controller, use tomcat to test
















//package com.pika.Onlinegrocerystore.Controller;
//
//import com.pika.Onlinegrocerystore.Services.ManagerService;
//import com.pika.Onlinegrocerystore.dao.IManagerDao;
//import com.pika.Onlinegrocerystore.domain.Manager;
//import org.apache.ibatis.session.SqlSession;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.io.InputStream;
//import java.util.List;
//
//@SpringBootTest(classes={ManagerController.class})
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class ManagerControllerTests {
//    private ManagerService managerService;
//
//    @BeforeAll
//    public void init() throws Exception {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        this.managerService = ac.getBean(ManagerService.class);
//    }
//
//    public static void printALlInfo(Manager manager){
//        System.out.print(manager.getId() + '\t');
//        System.out.print(manager.getUsername() + '\t');
//        System.out.print(manager.getPassword() + '\t');
//        System.out.print(manager.getEmail() + '\t');
//        System.out.println(manager.getRole() + '\t');
//    }
//
//    @Test
//    public void testFindById() throws Exception{
//        Manager manager = managerService.findById(1L);
//        printALlInfo(manager);
////        assertNotEquals(0, managers.size());
//    }
//
//}