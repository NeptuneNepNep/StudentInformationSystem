package com.information.dabtabase.ways;

import com.information.entity.student.StudentAccount;

import javax.ws.rs.core.Link;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterUser {
    //根据账号密码来注册新的账号进入数据库
    public boolean Register(int studentId,String password) throws SQLException, ClassNotFoundException {
        //连接
        boolean repeat = IsRepeat(studentId);
        if (repeat==false) {
            Connection conn = new LinkDataBase().LinkDB();
            String sql = "insert into login values(?,?)";
            //sql语句运输到数据库执行
            //创建预处理命令对象 写sql语句
            PreparedStatement psmt = conn.prepareStatement(sql);
            //填充参数
            psmt.setInt(1, studentId);
            psmt.setString(2, password);
            //执行更新 返回影响行数
            int l = psmt.executeUpdate();
            System.out.println("改变行数=" + l);
        }
        //出现重复id
        else {
            System.out.println("repeat");
        }
        return repeat;


    }
    public boolean IsRepeat(int studentId) throws SQLException, ClassNotFoundException {
        boolean charge = false;
        Connection conn = new LinkDataBase().LinkDB();
        String sql = "select * from login";
        //sql语句运输到数据库执行
        //创建预处理命令对象 写sql语句
        PreparedStatement psmt = conn.prepareStatement(sql);
        //填充参数
        //执行更新 返回影响行数
        ResultSet rs = psmt.executeQuery();
        while(rs.next()){

            int userId = rs.getInt(1);
            if(userId==studentId)
            {
                //表示重复
                charge = true;
                break;
            }


        }
        psmt.close();
        conn.close();
        return charge;


    }
}
