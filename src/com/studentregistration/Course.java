package com.studentregistration;

public class Course {

    private int courseId;
    private String courseName;
    private String duration;
    private double fee;

    public Course(int courseId, String courseName,
                  String duration, double fee) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public Course(String courseName, String duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDuration() {
        return duration;
    }

    public double getFee() {
        return fee;
    }
}
