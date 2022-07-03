package com.information.dabtabase.ways;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LinkDataBase {
    public Connection LinkDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.information.dabtabase.ways.LinkDataBase");
        String url = "jdbc:mysql://localhost:3306/student";
        String userName = "root";
        String passWord = "123456";
        Connection conn = DriverManager.getConnection(url, userName, passWord);
        return conn;
    }
}
