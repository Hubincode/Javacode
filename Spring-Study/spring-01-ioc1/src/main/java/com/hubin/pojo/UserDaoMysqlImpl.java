package com.hubin.pojo;

public class UserDaoMysqlImpl implements UserDao{

    @Override
    public void getuser() {
        System.out.println("Mysql获取默认user");
    }
}
