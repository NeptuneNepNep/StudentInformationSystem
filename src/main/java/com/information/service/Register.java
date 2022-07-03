package com.information.service;

import com.information.dabtabase.StrategyUseDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registerUser")
public class Register extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        String password = req.getParameter("password");
        System.out.println("注册的ID是"+studentId);
        //初始化方法库
        StrategyUseDataBase strategyUseDataBase = new StrategyUseDataBase();
        try {
            boolean repeat  = strategyUseDataBase.RegisterUsers(studentId,password);
            if(repeat==true) {
                req.setAttribute("repeat","用户名重复");
                req.getRequestDispatcher("register.jsp").forward(req,resp);

            }
            //用户名不重复说明注册成功 进入成功界面 并设置req newStudent
            else{
                req.setAttribute("newStudent",studentId);
                req.getRequestDispatcher("registerTrue.jsp").forward(req,resp);
                System.out.println("注册成功");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
