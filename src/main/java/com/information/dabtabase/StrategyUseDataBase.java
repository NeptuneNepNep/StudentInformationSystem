package com.information.dabtabase;

import com.information.dabtabase.ways.RegisterUser;
import com.information.dabtabase.ways.ShowScores;
import com.information.dabtabase.ways.VerifyLogin;
import com.information.entity.student.CourseScoreList;
import com.information.entity.student.StudentAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class StrategyUseDataBase {
   //连接学生的数据库
    //根据不同需求做不同的操作
    public List<StudentAccount> VerifyLog() throws SQLException, ClassNotFoundException {
       return new VerifyLogin().GetStudentAccountList();

    }
    public List<CourseScoreList> CheckScore(int studentId) throws SQLException, ClassNotFoundException {
         return new ShowScores().Show(studentId);
    }
   //返回是否重复 重复为true;
    public  boolean RegisterUsers(int studentId,String password) throws SQLException, ClassNotFoundException {
        return new RegisterUser().Register(studentId, password);

    }
}
