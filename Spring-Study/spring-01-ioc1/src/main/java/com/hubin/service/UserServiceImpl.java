package com.hubin.service;

import com.hubin.pojo.UserDao;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }
    @Override
    public void getUser() {
        userDao.getuser();
    }
}
