package com.information.service;

import com.information.dabtabase.StrategyUseDataBase;
import com.information.entity.student.StudentAccount;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Link;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/checkLogin")
public class CheckLogin extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            int studentId = Integer.parseInt(req.getParameter("studentId"));
            String password = req.getParameter("password");


           boolean charge = Check(studentId,password);

           req.setAttribute("charge",charge);
            //登陆失败
            if(charge==false) {
                req.getRequestDispatcher("login.jsp").forward(req, res);
            }
            else {
                //成功就设置session
                HttpServletRequest request = (HttpServletRequest)req;
                HttpSession session = request.getSession();
                session.setAttribute("studentId",studentId);
                req.getRequestDispatcher("Hello.jsp").forward(req,res);
            }
            } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean Check(int studentId,String password) throws SQLException, ClassNotFoundException {
        boolean charge = false;
        StrategyUseDataBase strategyUseDataBase = new StrategyUseDataBase();
        List<StudentAccount> studentAccountList = strategyUseDataBase.VerifyLog();
        for (int i = 0; i<studentAccountList.size();i++) {
            System.out.println("学号"+studentAccountList.get(i).getStudentId());
            System.out.println("密码"+studentAccountList.get(i).getPassword());
            System.out.println(studentAccountList.get(i).getStudentId());
            System.out.println(studentAccountList.get(i).getPassword());
            if(studentId==studentAccountList.get(i).getStudentId()&&password.equals(studentAccountList.get(i).getPassword()))
            { charge = true;}

        }
        return charge;
    }


}
