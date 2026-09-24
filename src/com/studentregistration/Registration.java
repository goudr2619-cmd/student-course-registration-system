package com.studentregistration;

import java.sql.Date;

public class Registration {

    private int registrationId;
    private int studentId;
    private int courseId;
    private Date registrationDate;
    private String status;

    public Registration(int studentId, int courseId,
                        Date registrationDate, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public String getStatus() {
        return status;
    }
}