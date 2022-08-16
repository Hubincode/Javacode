package com.hubin.service.role;

import com.hubin.dao.BaseDao;
import com.hubin.dao.role.RoleDao;
import com.hubin.dao.role.RoleDaoImpl;
import com.hubin.pojo.Role;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RoleServiceImpl implements RoleService{
    private RoleDao roleDao=null;

    public RoleServiceImpl() {
        this.roleDao = new RoleDaoImpl();
    }

    @Override
    public List<Role> getRoleList(){
        Connection connection=null;
        List<Role> roleList=null;
        try {
            connection= BaseDao.getConnection();
            roleList=roleDao.getRoleList(connection);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            BaseDao.close(connection,null,null);
        }

        return roleList;
    }
    @Test
    public void test(){
        RoleService roleService=new RoleServiceImpl();
        List<Role> roleList=null;
        roleList=roleService.getRoleList();
        for (Role role:roleList){
            System.out.println(role.getId()+"\t"+role.getRoleName()+"\t"+role.getRoleCode());
        }
    }
}
