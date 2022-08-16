package com.hubin.dao;

import com.hubin.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> selectUser();
    //根据id查询用户
    User selectUserById(int id);
    //通过密码和用户名查询用户
    User selectUserByNP(@Param("username")String username,@Param("pwd")String pwd);
    //通过密码和用户名查询用户
    User selectUserByNP2(Map<String,Object> map);
    //添加一个用户
    int addUser(User user);
    //修改一个用户
    int updateUser(User user);
    //根据id删除用户
    int deleteUser(int id);
//    @Select(" update user set name=#{name},pwd=#{pwd} where id = #{id}")
//    int updateUser(User user);
}