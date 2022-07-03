package com.information.dabtabase.ways;

import com.information.entity.student.StudentAccount;

import javax.ws.rs.core.Link;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VerifyLogin {
   public List<StudentAccount> GetStudentAccountList() throws SQLException, ClassNotFoundException {
       //建立连接
       List<StudentAccount> studentAccountList = new ArrayList<>();
       Connection conn = (new LinkDataBase()).LinkDB();
       String sql = "select * from login";
       //sql语句运输到数据库执行
       //创建预处理命令对象 写sql语句
       PreparedStatement psmt = conn.prepareStatement(sql);
       //填充参数
       //执行更新 返回影响行数
       ResultSet rs = psmt.executeQuery();
       while(rs.next()){

           int userId = rs.getInt(1);
           String password = rs.getString(2);
           StudentAccount studentAccount = new StudentAccount(userId,password);
           studentAccountList.add(studentAccount);


       }
       psmt.close();
       conn.close();
       return studentAccountList;
   }

}
