package com.information.entity.student;

public class StudentAccount {
    private  int studentId;
    private String password;

    public StudentAccount(int studentId, String password) {

        this.studentId = studentId;
        this.password = password;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
