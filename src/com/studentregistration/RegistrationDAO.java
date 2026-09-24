package com.studentregistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationDAO {

    public void registerStudent(int studentId, int courseId) {

        String sql = "INSERT INTO registrations "
                   + "(student_id, course_id, registration_date, status) "
                   + "VALUES (?, ?, CURDATE(), ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.setString(3, "Registered");

            ps.executeUpdate();

            System.out.println("Student registered successfully.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewCoursesByStudent(int studentId) {

        String sql =
            "SELECT c.course_id, c.course_name, c.duration, "
          + "c.fee, r.registration_date, r.status "
          + "FROM registrations r "
          + "JOIN courses c ON r.course_id = c.course_id "
          + "WHERE r.student_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- Registered Courses ---");

            while (rs.next()) {

                System.out.println(
                    "Course ID: " + rs.getInt("course_id")
                    + " | Course: " + rs.getString("course_name")
                    + " | Duration: " + rs.getString("duration")
                    + " | Fee: " + rs.getDouble("fee")
                    + " | Date: " + rs.getDate("registration_date")
                    + " | Status: " + rs.getString("status")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewStudentsByCourse(int courseId) {

        String sql =
            "SELECT s.student_id, s.name, s.email, s.phone, "
          + "r.registration_date, r.status "
          + "FROM registrations r "
          + "JOIN students s ON r.student_id = s.student_id "
          + "WHERE r.course_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, courseId);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- Registered Students ---");

            while (rs.next()) {

                System.out.println(
                    "Student ID: " + rs.getInt("student_id")
                    + " | Name: " + rs.getString("name")
                    + " | Email: " + rs.getString("email")
                    + " | Phone: " + rs.getString("phone")
                    + " | Date: " + rs.getDate("registration_date")
                    + " | Status: " + rs.getString("status")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
