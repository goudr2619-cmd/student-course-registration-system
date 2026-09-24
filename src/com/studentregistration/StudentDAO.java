package com.studentregistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

    public void addStudent(Student student) {

        String sql = "INSERT INTO students "
                   + "(name, email, phone, department) "
                   + "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPhone());
            ps.setString(4, student.getDepartment());

            ps.executeUpdate();

            System.out.println("Student added successfully.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewStudents() {

        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- Students ---");

            while (rs.next()) {

                System.out.println(
                    "ID: " + rs.getInt("student_id")
                    + " | Name: " + rs.getString("name")
                    + " | Email: " + rs.getString("email")
                    + " | Phone: " + rs.getString("phone")
                    + " | Department: " + rs.getString("department")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateStudent(int id, String name,
                              String email, String phone,
                              String department) {

        String sql = "UPDATE students SET name=?, email=?, "
                   + "phone=?, department=? WHERE student_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, department);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student updated successfully.");
            else
                System.out.println("Student not found.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void removeStudent(int id) {

        String sql = "DELETE FROM students WHERE student_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student removed successfully.");
            else
                System.out.println("Student not found.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}