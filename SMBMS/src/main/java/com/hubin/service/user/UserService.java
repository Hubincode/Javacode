package com.hubin.service.user;

import com.hubin.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public User login(String userCode,String userPassword);
    public Boolean UpdatePassword( String newPwd, int id);
    public int getUserCount(String userName, int userRole);
    public List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize);

}
