package com.hubin.service.user;

import com.hubin.dao.BaseDao;
import com.hubin.dao.user.UserDao;
import com.hubin.dao.user.UserDaoImpl;
import com.hubin.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDao userDao;
//    public UserServiceImpl(UserDao userDao){
//        this.userDao=userDao;
//    }
    public UserServiceImpl(){
    this.userDao=new UserDaoImpl();
}
    @Override
    public User login(String userCode, String userPassword) {
        Connection connection=null;
        User user=null;
        connection= BaseDao.getConnection();
        user=userDao.getLoginUserInfo(connection,userCode,userPassword);
        BaseDao.close(connection,null,null);
        return  user;
    }

    @Override
    public Boolean UpdatePassword(String newPwd, int id) {
        Connection connection=null;
        int rs=0;
        Boolean flag=false;
        connection= BaseDao.getConnection();

        if(userDao.upatePwd(connection,newPwd,id)>0){
            flag=true;
        }
        BaseDao.close(connection,null,null);
        return flag;
    }

    @Override
    public int getUserCount(String userName, int userRole){
        Connection connection=null;
        int rs=0;
        int count=0;
        try {
            connection= BaseDao.getConnection();
            count=userDao.getUsercount(connection,userName,userRole);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            BaseDao.close(connection,null,null);
        }
        return count;
    }

    @Override
    public List<User> getUserList( String userName, int userRole, int currentPageNo, int pageSize)  {
        Connection connection=null;
        int rs=0;
        List<User> userList=null;
        connection= BaseDao.getConnection();
        try {
            userList=userDao.getUserList(connection,userName,userRole,currentPageNo,pageSize);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            BaseDao.close(connection,null,null);
        }


        return userList;
    }

    @Test
    public void test(){
        UserDaoImpl userDao=new UserDaoImpl();
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("admin","12bfasbka");
        System.out.println(admin.getUserPassword());
    }
    @Test
    public void test2() throws SQLException {
        List userList = new UserServiceImpl().getUserList(null,0,2,5);
        //(3-1)*5 = 10,所以展示的是10~14条数据，但是一共只有12条,注意：MYSQL中结果index从0开始
        for (Object o : userList) {
            System.out.println(((User)o).getUserName());
        }
    }
}
