package com.hubin.dao.user;

import com.hubin.dao.BaseDao;
import com.hubin.pojo.User;
import com.mysql.jdbc.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
    @Override
    public User getLoginUserInfo(Connection connection, String userCode, String userPassword) {
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        User user=null;
        if(connection!=null){
            String sql="SELECT * FROM smbms_user WHERE userCode=? and userPassword=?";
            Object[] params={userCode,userPassword};
            resultSet= BaseDao.executeQuery(sql,params,connection,preparedStatement,resultSet);
            try {
                while (resultSet.next()){
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setUserCode(resultSet.getString("userCode"));
                    user.setUserName(resultSet.getString("userName"));
                    user.setUserPassword(resultSet.getString("userPassword"));
                    user.setGender(resultSet.getInt("gender"));
                    user.setBirthday(resultSet.getDate("birthday"));
                    user.setPhone(resultSet.getString("phone"));
                    user.setAddress(resultSet.getString("address"));
                    user.setUserRole(resultSet.getInt("userRole"));
                    user.setCreatedBy(resultSet.getInt("createdBy"));
                    user.setCreationDate(new java.sql.Date(resultSet.getTimestamp("creationDate").getTime()));
                    user.setModifyBy(resultSet.getInt("modifyBy"));
                    user.setModifyDate(new java.sql.Date(resultSet.getTimestamp("modifyDate").getTime()));
//                    Date date=new java.sql.Date(resultSet.getTimestamp("modifyDate").getTime());
//                    user.setModifyDate(date);



                }
            BaseDao.close(null,preparedStatement,resultSet);//因为数据库的连接可能不只是这一个操作，所以我们不应该做完一件事就把数据库连接对象销毁，所以conn处传的null
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            catch (NullPointerException exception){

            }

        }
        return user;
    }
    @Override
    public int upatePwd(Connection connection, String newPwd, int id) {
        PreparedStatement preparedStatement=null;
        int rs=0;
        User user=null;
        if(connection!=null){
            String sql="UPDATE smbms_user SET userPassword=? WHERE id =?";
            Object[] params={newPwd,id};
            rs= BaseDao.executeUpdate(sql,params,connection,preparedStatement);
            BaseDao.close(null,preparedStatement,null);//因为数据库的连接可能不只是这一个操作，所以我们不应该做完一件事就把数据库连接对象销毁，所以conn处传的null
        }
        return rs;
    }

    @Override
    public int getUsercount(Connection connection, String userName, int userRole) {
        PreparedStatement preparedStatement=null;
        ResultSet rs = null;
        int count=0;
        if(connection!=null){
            StringBuffer sql=new StringBuffer();
            sql.append("SELECT COUNT(1) COUNT FROM smbms_user u,smbms_role r where u.userRole=r.id");
            List<Object> list = new ArrayList<Object>();//创建一个list来存储我们要拼接的筛选条件，由于我们不能限制传入的参数的数据类型，所以泛型指定为object
            if (!StringUtils.isNullOrEmpty(userName)){
                sql.append(" AND userName like ?");
                list.add("%"+userName+"%");
            }
            if (userRole>0){
                sql.append(" AND userRole = ?");
                list.add(userRole);
            }
            Object[] params=list.toArray();
            rs= BaseDao.executeQuery(sql.toString(),params,connection,preparedStatement,rs);
            try {
                if(rs.next()) {
                    count=rs.getInt("COUNT");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            BaseDao.close(null,preparedStatement,null);//因为数据库的连接可能不只是这一个操作，所以我们不应该做完一件事就把数据库连接对象销毁，所以conn处传的null
        }
        return count;
    }

    @Override
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        int count = 0;
        List<User> userList = new ArrayList<User>();//创建一个list来存储我们要拼接的筛选条件，由于我们不能限制传入的参数的数据类型，所以泛型指定为object

        if (connection != null) {
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT u.*,r.roleName as userRoleName  FROM smbms_user u,smbms_role r where u.userRole=r.id ");
            List<Object> list = new ArrayList<Object>();//创建一个list来存储我们要拼接的筛选条件，由于我们不能限制传入的参数的数据类型，所以泛型指定为object
            if (!StringUtils.isNullOrEmpty(userName)) {
                sql.append(" AND userName like ?");
                list.add("%" + userName + "%");
            }
            if (userRole > 0) {
                sql.append(" AND userRole = ?");
                list.add(userRole);
            }
            sql.append(" ORDER BY u.creationDate DESC LIMIT ?,?");//在sql最后追加一个排序和分页
            currentPageNo = (currentPageNo - 1) * pageSize;//减一的原因就是MYSQL分页的index从0开始

            list.add(currentPageNo);//从哪一个下标开始
            list.add(pageSize);//从currentPageNo连续取几个
            Object[] params = list.toArray();
            rs = BaseDao.executeQuery(sql.toString(), params, connection, preparedStatement, rs);
            while (rs.next()) {
                User _user = new User();
                _user.setId(rs.getInt("id"));
                _user.setUserCode(rs.getString("userCode"));
                _user.setUserName(rs.getString("userName"));
                _user.setGender(rs.getInt("gender"));
                _user.setBirthday(rs.getDate("birthday"));
                _user.setPhone(rs.getString("phone"));
                _user.setUserRole(rs.getInt("userRole"));
                _user.setUserRoleName(rs.getString("userRoleName"));//这个属性是在POJO中新加入的，数据表中没有
                userList.add(_user);//将查到的这个对象分装为对象并存入List集合中
                BaseDao.close(null, preparedStatement, null);//因为数据库的连接可能不只是这一个操作，所以我们不应该做完一件事就把数据库连接对象销毁，所以conn处传的null
            }

        }
        return userList;
    }


}
