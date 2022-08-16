package com.hubin.servlet.user;

import com.hubin.dao.role.RoleDaoImpl;
import com.hubin.dao.user.UserDaoImpl;
import com.hubin.pojo.Role;
import com.hubin.pojo.User;
import com.hubin.service.role.RoleService;
import com.hubin.service.role.RoleServiceImpl;
import com.hubin.service.user.UserService;
import com.hubin.service.user.UserServiceImpl;
import com.hubin.util.Constants;
import com.hubin.util.PageSupport;
import com.mysql.jdbc.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String method=req.getParameter("method");
        if (method!=null&&method.equals("pwdmodify")){
            this.pwdmodify(req,resp);
        }
        if (method!=null&&method.equals("savepwd")){
            this.updatPwd(req,resp);
        }
        if (method!=null&&method.equals("query")){
            this.query(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    public void updatPwd(HttpServletRequest req,HttpServletResponse resp){
        Boolean flag=false;
        Object user=req.getSession().getAttribute(Constants.USER_SESSION);
        String newPwd=req.getParameter("newpassword");
        if(user!=null&& !StringUtils.isNullOrEmpty(newPwd)) {
            UserService userService = new UserServiceImpl();
            flag = userService.UpdatePassword(newPwd, ((User) user).getId());
            if (flag) {//修改成功
                req.getSession().removeAttribute(Constants.USER_SESSION);
                req.setAttribute("message", "密码修改成功");
            } else {
                req.setAttribute("message", "密码修改失败");
            }
        }else {
            req.setAttribute("message", "密码设置错误，请重新输入");
        }
        try {
            req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void pwdmodify(HttpServletRequest req,HttpServletResponse resp){
        Object user=req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");
        Map<String,String> resultMap=new HashMap<String, String>();
        if (user==null){
            resultMap.put("result","sessionerror");
        }else if(StringUtils.isNullOrEmpty(oldpassword)){
            resultMap.put("result","error");
        }else {
            String userPassword=((User)user).getUserPassword();
            if(userPassword.equals(oldpassword)){
                resultMap.put("result","true");
            }else {
                resultMap.put("result","false");
            }
        }
        //将Map集合中的数据转化为JSOn格式传输给前端
        resp.setContentType("application/JSON");
        PrintWriter writer= null;
        try {
            writer = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.write(JSONArray.toJSONString(resultMap));
        writer.flush();
        writer.close();
    }
    public void query(HttpServletRequest req,HttpServletResponse resp) {
        String queryname=req.getParameter("queryname");
        String queryUserRole=req.getParameter("queryUserRole");
        String pageIndex=req.getParameter("pageIndex");
        List<User> userList=null;

        int UserRole=0;
        int pageSize=5;
        int currentPageNo=1;
        if(queryname==null){
             queryname="";
        }
        if(queryUserRole!=null&&queryUserRole!=""){
             UserRole=Integer.parseInt(queryUserRole);
        }
        if(pageIndex!=null){
             currentPageNo=Integer.parseInt(pageIndex);
        }
        UserService userService=new UserServiceImpl();

        int totalCount =userService.getUserCount(queryname,UserRole);

        PageSupport pageSupport=new PageSupport();
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        pageSupport.setCurrentPageNo(currentPageNo);

        int totalPageCount=0;
        totalPageCount=pageSupport.getTotalPageCount();

        if(currentPageNo<1){
            currentPageNo=1;
        }else if(currentPageNo>pageSupport.getTotalPageCount()){
            currentPageNo=totalPageCount;
        }

        userList=userService.getUserList(queryname,UserRole,currentPageNo,pageSize);
        req.setAttribute("userList",userList);

        List<Role> roleList=new RoleServiceImpl().getRoleList();
        req.setAttribute("roleList",roleList);

        req.setAttribute("queryUserName",queryname);
        req.setAttribute("queryUserRole",queryUserRole);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("totalCount",totalCount);
        req.setAttribute("currentPageNo",currentPageNo);
        try{
            System.out.println("=============进入到servlet，且i调用method = query");

            req.getRequestDispatcher("userlist.jsp").forward(req,resp);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
