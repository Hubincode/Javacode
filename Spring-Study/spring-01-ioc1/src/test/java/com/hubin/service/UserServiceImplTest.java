package com.hubin.service;


import com.hubin.pojo.UserDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImplTest {
    @Test
    public void testSetUserDao() {
        UserService userService=new UserServiceImpl();
        ((UserServiceImpl)userService).setUserDao(new UserDaoImpl());
        userService.getUser();
    }
    @Test
    public void testSetUserDao_spring() {
        ApplicationContext context=new  ClassPathXmlApplicationContext("beans.xml");
        UserServiceImpl userServiceImpl=(UserServiceImpl) context.getBean("UserServiceImpl");
        userServiceImpl.getUser();
    }
}