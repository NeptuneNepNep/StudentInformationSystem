package com.information.dabtabase.ways;

import com.information.entity.student.CourseScoreList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowScores {
    //通过用户id查成绩
    public List<CourseScoreList> Show(int studentId) throws SQLException, ClassNotFoundException {
        //建立存储表
        List courseScoreList = new ArrayList<>();
        //连接数据库
        Connection conn = (new LinkDataBase()).LinkDB();
        String sql = "select * from tableofscore A join student B on A.studentid = B.studentid join course C on A.courseid = C.courseid where A.studentid = ?;";
        //sql语句运输到数据库执行
        //创建预处理命令对象 写sql语句
        PreparedStatement psmt = conn.prepareStatement(sql);
        //填充参数
        psmt.setInt(1,studentId);
        //执行更新 返回影响行数
        ResultSet rs = psmt.executeQuery();
        while(rs.next()) {
            String studentName = rs.getString(7);
            String courseName = rs.getString(9);
            String teacher = rs.getString(10);
            int score = rs.getInt(4);
            String level = rs.getString(5);
            int credit = rs.getInt(11);
            System.out.println(studentName+" "+courseName+" "+credit);
            CourseScoreList scoreList = new CourseScoreList(studentName,courseName,teacher,score,credit,level);
            courseScoreList.add(scoreList);

        }
        return courseScoreList;
    }
}
