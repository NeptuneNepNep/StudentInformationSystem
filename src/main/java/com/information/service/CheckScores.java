package com.information.service;

import com.information.dabtabase.StrategyUseDataBase;
import com.information.entity.student.CourseScoreList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//实现已经登录的对象查成绩功能
@WebServlet("/checkScores")
public class CheckScores extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = (int) req.getSession().getAttribute("studentId");
        System.out.println("正在查询"+studentId);
        try {
            //获取成绩列表
            List<CourseScoreList> courseScoreLists = Check(studentId);
            System.out.println("查询成功");
            //查询成功后将成绩表设置到session上并转发到成绩单网页
            req.getSession().setAttribute("courseScoreLists",courseScoreLists);
            req.getRequestDispatcher("CourseLists.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    //查询成绩方法
    public List<CourseScoreList> Check(int studentId) throws SQLException, ClassNotFoundException {
        StrategyUseDataBase strategyUseDataBase = new StrategyUseDataBase();
        List<CourseScoreList> courseScoreLists = strategyUseDataBase.CheckScore(studentId);
        System.out.println(courseScoreLists.get(0).getScore());

        return courseScoreLists;
    }
}
