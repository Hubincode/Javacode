package com.hubin.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 *
 */
//操作数据库的公共类
public class BaseDao {
    private static String DRIVER;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    static{
        //读取配置文件
        //1、创建properties对象
        Properties properties=new Properties();
        //2、通过类加载器资源文件为字节输入流
        InputStream inputStream=BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DRIVER=properties.getProperty("driver");
        URL=properties.getProperty("url");
        USERNAME=properties.getProperty("username");
        PASSWORD=properties.getProperty("password");
    }

    /**
     *
     * @return
     */
    //1、获取数据库链接对象
    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName(DRIVER);
            connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    /**
     *
     * @param sql
     * @param parems
     * @param connection
     * @param preparedStatement
     * @return
     */
//    2、查询公共方法
    public static ResultSet executeQuery(String sql,Object[] parems,Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        try {
            preparedStatement=connection.prepareStatement(sql);
            for (int i=1;i<=parems.length;i++){
                preparedStatement.setObject(i,parems[i-1]);
            }
            resultSet=preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
    //3、编写修改公共方法
    public static int executeUpdate(String sql,Object[] parems,Connection connection,PreparedStatement preparedStatement){
        int result=0;
        try {
            preparedStatement=connection.prepareStatement(sql);
            for (int i=1;i<=parems.length;i++){
                preparedStatement.setObject(i,parems[i-1]);
            }
            result=preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    //4、关闭资源
    public static boolean close(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        boolean flag = true;
        if (resultSet!=null){
            try {
                resultSet.close();
                resultSet = null;//让这个变量为null，gc就会自动对其进行回收
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;//关闭失败就将flag设置false
            }
        }
        if (preparedStatement!=null){
            try {
                preparedStatement.close();
                preparedStatement = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }
        if (connection!=null){
            try {
                connection.close();
                connection = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }
        return flag;//返回关闭结果
    }
}
