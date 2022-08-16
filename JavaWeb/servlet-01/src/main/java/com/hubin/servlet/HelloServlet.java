package com.hubin.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter Writr= resp.getWriter();
//        Writr.println("Hello,servlet!!!!");
            ServletContext context = this.getServletContext();

            String username = "胡斌"; //数据
            context.setAttribute("username",username); //将一个数据保存在了ServletContext中，名字为：username 。值 username

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req,resp);
    }
}
