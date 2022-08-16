package com.hubin.dao.user;

import com.hubin.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    /**
     * 获取要进行登录的用户
     * @param connection 连接数据库
     * @param userCode 用户名
     * @param userPassword 密码
     * @return
     */
    public User getLoginUserInfo(Connection connection,String userCode,String userPassword);
    public int upatePwd(Connection connection,String newPwd,int id);
    public int getUsercount(Connection connection,String userName,int userRole)throws SQLException;
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws SQLException;
}
