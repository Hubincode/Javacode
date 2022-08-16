package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.entity.User;
import com.atguigu.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelcetlist(){
        System.out.println("-----------selectlist-------------------");
        List<User> users=userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    public void testInsert(){
        User user=new User();
        user.setName("hubin5");
        user.setAge(18);
        user.setEmail("hubin.hb@vivo.com");
        int result=userMapper.insert(user);
        System.out.println(result);
        System.out.println(user);
    }
    @Test
    public void testUpdate(){
        User user=new User();
        user.setId(1L);
        user.setAge(18);
        user.setEmail("hubin.hb@vivo.com");
        int result=userMapper.updateById(user);
        System.out.println(result);
        System.out.println(user);
    }



}
