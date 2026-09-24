package com.studentregistration;

public class Student {

    private int studentId;
    private String name;
    private String email;
    private String phone;
    private String department;

    public Student(int studentId, String name, String email,
                   String phone, String department) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
    }

    public Student(String name, String email,
                   String phone, String department) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDepartment() {
        return department;
    }
}
