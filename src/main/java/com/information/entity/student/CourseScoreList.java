package com.information.entity.student;

public class CourseScoreList {
    String studentName;
    String CourseName;
    String teacherName;
    int score;
    int credit;
    String level;

    public CourseScoreList(String studentName, String courseName, String teacherName, int score, int credit, String level) {
        this.studentName = studentName;
        this.CourseName = courseName;
        this.teacherName = teacherName;
        this.score = score;
        this.credit = credit;
        this.level = level;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
