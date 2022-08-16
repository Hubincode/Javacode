package com.hubin.dao.role;

import com.hubin.dao.BaseDao;
import com.hubin.pojo.Role;
import com.hubin.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    @Override
    public List<Role> getRoleList(Connection connection) throws SQLException {
        PreparedStatement preparedStatement=null;
        List<Role> roleList=new ArrayList<Role>();
        ResultSet resultSet=null;
        Role role=null;
        if(connection!=null){
            String sql="SELECT * FROM smbms_role";
            Object[] params={};
            resultSet= BaseDao.executeQuery(sql,params,connection,preparedStatement,resultSet);
            try {
                while (resultSet.next()){
                    role = new Role();
                    role.setId(resultSet.getInt("id"));
                    role.setRoleCode(resultSet.getString("roleCode"));
                    role.setRoleName(resultSet.getString("roleName"));
                    role.setCreatedBy(resultSet.getInt("CreatedBy"));
                    role.setCreationDate(resultSet.getDate("CreationDate"));
                    role.setModifyBy(resultSet.getInt("ModifyBy"));
                    role.setModifyDate(resultSet.getDate("ModifyDate"));

                    roleList.add(role);
                }
                BaseDao.close(null,preparedStatement,resultSet);//因为数据库的连接可能不只是这一个操作，所以我们不应该做完一件事就把数据库连接对象销毁，所以conn处传的null
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            catch (NullPointerException exception){

            }

        }
        return roleList;
    }
}
