package com.hubin.servlet.user;

import com.hubin.pojo.User;
import com.hubin.service.user.UserService;
import com.hubin.service.user.UserServiceImpl;
import com.hubin.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userservice=null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCode=req.getParameter("userCode");
        String userPassword=req.getParameter("userPassword");
        this.userservice=new UserServiceImpl();
        User user=userservice.login(userCode,userPassword);
        if(user!=null){
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            resp.sendRedirect("jsp/frame.jsp");
        }else {
            req.setAttribute("error","用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
