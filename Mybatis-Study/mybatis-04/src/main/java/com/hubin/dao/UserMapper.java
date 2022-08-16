package com.hubin.dao;

import com.hubin.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    @Select("select * from  mybatis.user")
    List<User> selectUser();
    //根据id查询用户
    @Select("select * from mybatis.user where id=#{id}")
    User selectUserById(int id);
    //通过密码和用户名查询用户
    @Select("select * from  mybatis.user where name=#{username} and pwd=#{pwd}" )
    User selectUserByNP(@Param("username")String username,@Param("pwd")String pwd);
    //通过密码和用户名查询用户
    User selectUserByNP2(Map<String,Object> map);
    //添加一个用户
    @Insert("insert into mybatis.user (id,name,pwd) values (#{id},#{name},#{pwd})")
    int addUser(User user);
    //修改一个用户
    @Update("update mybatis.user set name=#{name}, pwd=#{pwd} where id=#{id}")
    int updateUser(User user);
    //根据id删除用户
    @Delete("delete from user where id=#{id}")
    int deleteUser(int id);
//    @Select(" update user set name=#{name},pwd=#{pwd} where id = #{id}")
//    int updateUser(User user);
}