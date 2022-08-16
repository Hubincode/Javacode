package com.hubin.dao;

import com.hubin.pojo.User;
import com.hubin.utils.MybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest extends TestCase {
    static Logger logger=Logger.getLogger(UserMapperTest.class);
    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testselectUser()  {
        SqlSession session = MybatisUtils.getSession();
        try {
            //方法一:
            //List<User> users = session.selectList("com.kuang.mapper.UserMapper.selectUser");
            //方法二:
            logger.info("info：进入selectUser方法");
//            logger.debug("debug：进入selectUser方法");
//            logger.error("error: 进入selectUser方法");
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> users = mapper.selectUser();

            for (User user: users){
                System.out.println(user);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
    public void testselstUserById() {
        SqlSession session = MybatisUtils.getSession();
        try {
            UserMapper mapper=session.getMapper(UserMapper.class);
            User selectedUser=mapper.selectUserById(2);
            System.out.println(selectedUser);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
    public void testselstUserByNP() {
        SqlSession session = MybatisUtils.getSession();
        try {

            UserMapper mapper=session.getMapper(UserMapper.class);
            User selectedUser=mapper.selectUserByNP("狂神","asdfgh ");
            System.out.println(selectedUser);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
//    public void testselstUserByNP2()  {
//        SqlSession session = MybatisUtils.getSession();
//        try {
//            UserMapper mapper=session.getMapper(UserMapper.class);
//            Map<String,Object> map=new HashMap<String, Object>();
//            map.put("username","狂神");
//            map.put("pwd","asdfgh");
//            User selectedUser=mapper.selectUserByNP2(map);
//            System.out.println(selectedUser);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        finally {
//            session.close();
//        }
//    }
    public void testaddUser()  {
        SqlSession session = MybatisUtils.getSession();
        try {
//            UserMapper mapper=session.getMapper(UserMapper.class);
//            User user=new User(6,"胡斌","123456");
//            int i=mapper.addUser(user);
//            System.out.println(i);
//            session.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    public void testUpdateUser() {
        SqlSession session = MybatisUtils.getSession();
        try {
            UserMapper mapper=session.getMapper(UserMapper.class);
            User user=mapper.selectUserById(1);
            user.setPwd("1111111");
            int i=mapper.updateUser(user);
            System.out.println(i);
            session.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
    public void testdeleteUser(){
        SqlSession session = MybatisUtils.getSession();
        try {
            UserMapper mapper=session.getMapper(UserMapper.class);
            int i=mapper.deleteUser(1);
            System.out.println(i);
            session.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }

    }
}