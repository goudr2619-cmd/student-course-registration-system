package com.studentregistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDAO {

    public void addCourse(Course course) {

        String sql = "INSERT INTO courses "
                   + "(course_name, duration, fee) "
                   + "VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getDuration());
            ps.setDouble(3, course.getFee());

            ps.executeUpdate();

            System.out.println("Course added successfully.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewCourses() {

        String sql = "SELECT * FROM courses";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- Available Courses ---");

            while (rs.next()) {

                System.out.println(
                    "ID: " + rs.getInt("course_id")
                    + " | Course: " + rs.getString("course_name")
                    + " | Duration: " + rs.getString("duration")
                    + " | Fee: " + rs.getDouble("fee")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void removeCourse(int id) {

        String sql = "DELETE FROM courses WHERE course_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Course removed successfully.");
            else
                System.out.println("Course not found.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}