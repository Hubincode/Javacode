package com.hubin.dao;

import com.hubin.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();
}