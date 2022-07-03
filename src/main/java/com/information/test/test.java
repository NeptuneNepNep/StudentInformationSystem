package com.information.test;

import com.information.dabtabase.StrategyUseDataBase;
import com.information.dabtabase.ways.VerifyLogin;
import com.information.entity.student.CourseScoreList;
import com.information.entity.student.StudentAccount;


import java.sql.SQLException;
import java.util.List;

public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        StrategyUseDataBase strategyUseDataBase = new StrategyUseDataBase();
       strategyUseDataBase.RegisterUsers(4,"asdfgh");


    }
}
