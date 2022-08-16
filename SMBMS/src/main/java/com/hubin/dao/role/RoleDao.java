package com.hubin.dao.role;

import com.hubin.pojo.Role;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RoleDao {
    public List<Role> getRoleList(Connection connection) throws SQLException;

}
