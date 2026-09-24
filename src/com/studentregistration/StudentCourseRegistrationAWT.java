package com.studentregistration;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentCourseRegistrationAWT extends Frame
        implements ActionListener {

    // ================= COLORS =================

    Color navy = new Color(25, 45, 65);
    Color blue = new Color(45, 110, 180);
    Color light = new Color(245, 248, 252);
    Color text = new Color(50, 50, 50);

    // ================= STUDENT =================

    TextField studentId;
    TextField studentName;
    TextField studentEmail;

    Button addStudent;
    Button viewStudents;

    // ================= COURSE =================

    TextField courseId;
    TextField courseName;

    Button addCourse;
    Button viewCourses;

    // ================= REGISTRATION =================

    TextField regStudentId;
    TextField regCourseId;

    Button registerCourse;
    Button viewRegistrations;

    // ================= OUTPUT =================

    TextArea output;

    // ==================================================
    // CONSTRUCTOR
    // ==================================================

    public StudentCourseRegistrationAWT() {

        setTitle("Student Course Registration System");

        setSize(1050, 700);

        setLayout(new BorderLayout(10, 10));

        setBackground(light);

        // ==================================================
        // HEADER
        // ==================================================

        Panel header =
                new Panel(new BorderLayout());

        header.setBackground(navy);

        Label title =
                new Label(
                        "STUDENT COURSE REGISTRATION SYSTEM",
                        Label.CENTER);

        title.setFont(
                new Font("Arial", Font.BOLD, 25));

        title.setForeground(Color.WHITE);

        Label subtitle =
                new Label(
                        "Manage Students | Courses | Registrations",
                        Label.CENTER);

        subtitle.setFont(
                new Font("Arial", Font.PLAIN, 14));

        subtitle.setForeground(
                new Color(220, 230, 240));

        header.add(
                title,
                BorderLayout.CENTER);

        header.add(
                subtitle,
                BorderLayout.SOUTH);

        add(
                header,
                BorderLayout.NORTH);

        // ==================================================
        // MAIN PANEL
        // ==================================================

        Panel main =
                new Panel(
                        new GridLayout(1, 3, 15, 0));

        main.setBackground(light);

        // ==================================================
        // STUDENT PANEL
        // ==================================================

        Panel studentPanel =
                createCard("STUDENT DETAILS");

        studentId = new TextField();
        studentName = new TextField();
        studentEmail = new TextField();

        addField(
                studentPanel,
                "Student ID",
                studentId);

        addField(
                studentPanel,
                "Student Name",
                studentName);

        addField(
                studentPanel,
                "Email",
                studentEmail);

        addStudent =
                createButton("ADD STUDENT");

        viewStudents =
                createButton("VIEW STUDENTS");

        studentPanel.add(addStudent);
        studentPanel.add(viewStudents);

        addStudent.addActionListener(this);
        viewStudents.addActionListener(this);

        main.add(studentPanel);

        // ==================================================
        // COURSE PANEL
        // ==================================================

        Panel coursePanel =
                createCard("COURSE DETAILS");

        courseId = new TextField();
        courseName = new TextField();

        addField(
                coursePanel,
                "Course ID",
                courseId);

        addField(
                coursePanel,
                "Course Name",
                courseName);

        addCourse =
                createButton("ADD COURSE");

        viewCourses =
                createButton("VIEW COURSES");

        coursePanel.add(addCourse);
        coursePanel.add(viewCourses);

        addCourse.addActionListener(this);
        viewCourses.addActionListener(this);

        main.add(coursePanel);

        // ==================================================
        // REGISTRATION PANEL
        // ==================================================

        Panel registrationPanel =
                createCard("COURSE REGISTRATION");

        regStudentId = new TextField();
        regCourseId = new TextField();

        addField(
                registrationPanel,
                "Student ID",
                regStudentId);

        addField(
                registrationPanel,
                "Course ID",
                regCourseId);

        registerCourse =
                createButton("REGISTER COURSE");

        viewRegistrations =
                createButton("VIEW REGISTRATIONS");

        registrationPanel.add(registerCourse);
        registrationPanel.add(viewRegistrations);

        registerCourse.addActionListener(this);
        viewRegistrations.addActionListener(this);

        main.add(registrationPanel);

        add(
                main,
                BorderLayout.CENTER);

        // ==================================================
        // OUTPUT
        // ==================================================

        Panel outputPanel =
                new Panel(
                        new BorderLayout(5, 5));

        Label outputLabel =
                new Label("  SYSTEM OUTPUT");

        outputLabel.setFont(
                new Font("Arial", Font.BOLD, 15));

        outputLabel.setForeground(navy);

        output =
                new TextArea();

        output.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        14));

        output.setBackground(Color.WHITE);

        output.setForeground(text);

        output.setEditable(false);

        output.setText(
                "============================================================\n"
                + "              WELCOME TO STUDENT COURSE SYSTEM\n"
                + "============================================================\n\n"
                + "  Select an operation from the options above.\n\n"
                + "  STUDENT\n"
                + "  • Add Student\n"
                + "  • View Students\n\n"
                + "  COURSE\n"
                + "  • Add Course\n"
                + "  • View Courses\n\n"
                + "  REGISTRATION\n"
                + "  • Register Course\n"
                + "  • View Registrations\n"
                + "============================================================"
        );

        outputPanel.add(
                outputLabel,
                BorderLayout.NORTH);

        outputPanel.add(
                output,
                BorderLayout.CENTER);

        add(
                outputPanel,
                BorderLayout.SOUTH);

        // ==================================================
        // CLOSE WINDOW
        // ==================================================

        addWindowListener(
                new WindowAdapter() {

                    public void windowClosing(
                            WindowEvent e) {

                        dispose();
                    }
                });

        setLocationRelativeTo(null);

        setVisible(true);
    }

    // ==================================================
    // CREATE CARD
    // ==================================================

    private Panel createCard(
            String heading) {

        Panel panel =
                new Panel(
                        new GridLayout(
                                0,
                                1,
                                8,
                                10));

        panel.setBackground(Color.WHITE);

        Label title =
                new Label(
                        heading,
                        Label.CENTER);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        17));

        title.setForeground(navy);

        panel.add(title);

        return panel;
    }

    // ==================================================
    // ADD FIELD
    // ==================================================

    private void addField(
            Panel panel,
            String name,
            TextField field) {

        Label label =
                new Label(name);

        label.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13));

        label.setForeground(text);

        field.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13));

        panel.add(label);

        panel.add(field);
    }

    // ==================================================
    // CREATE BUTTON
    // ==================================================

    private Button createButton(
            String name) {

        Button button =
                new Button(name);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        12));

        button.setBackground(blue);

        button.setForeground(Color.WHITE);

        return button;
    }

    // ==================================================
    // ACTION PERFORMED
    // ==================================================

    public void actionPerformed(
            ActionEvent e) {

        try {

            Connection con =
                    DBConnection.getConnection();

            // ==================================================
            // ADD STUDENT
            // ==================================================

            if (e.getSource() == addStudent) {

                String sql =
                        "INSERT INTO student_registration.student "
                        + "(student_id, student_name, email) "
                        + "VALUES (?, ?, ?)";

                PreparedStatement ps =
                        con.prepareStatement(sql);

                ps.setInt(
                        1,
                        Integer.parseInt(
                                studentId.getText()));

                ps.setString(
                        2,
                        studentName.getText());

                ps.setString(
                        3,
                        studentEmail.getText());

                ps.executeUpdate();

                output.setText(
                        "============================================================\n"
                        + "                  STUDENT ADDED\n"
                        + "============================================================\n\n"
                        + "  Student ID   : "
                        + studentId.getText() + "\n"
                        + "  Student Name : "
                        + studentName.getText() + "\n"
                        + "  Email        : "
                        + studentEmail.getText() + "\n\n"
                        + "  Student record saved successfully!\n"
                        + "============================================================"
                );

                ps.close();
            }

            // ==================================================
            // VIEW STUDENTS
            // ==================================================

            else if (
                    e.getSource() == viewStudents) {

                Statement st =
                        con.createStatement();

                ResultSet rs =
                        st.executeQuery(
                                "SELECT * "
                                + "FROM student_registration.student");

                output.setText(
                        "============================================================\n"
                        + "                    STUDENT LIST\n"
                        + "============================================================\n\n");

                boolean found = false;

                while (rs.next()) {

                    found = true;

                    output.append(
                            "  Student ID   : "
                            + rs.getInt("student_id")
                            + "\n");

                    output.append(
                            "  Student Name : "
                            + rs.getString("student_name")
                            + "\n");

                    output.append(
                            "  Email        : "
                            + rs.getString("email")
                            + "\n");

                    output.append(
                            "------------------------------------------------------------\n");
                }

                if (!found) {

                    output.append(
                            "  No student records found.\n");
                }

                rs.close();

                st.close();
            }

            // ==================================================
            // ADD COURSE
            // ==================================================

            else if (
                    e.getSource() == addCourse) {

                String sql =
                        "INSERT INTO student_registration.course "
                        + "(course_id, course_name) "
                        + "VALUES (?, ?)";

                PreparedStatement ps =
                        con.prepareStatement(sql);

                ps.setInt(
                        1,
                        Integer.parseInt(
                                courseId.getText()));

                ps.setString(
                        2,
                        courseName.getText());

                ps.executeUpdate();

                output.setText(
                        "============================================================\n"
                        + "                   COURSE ADDED\n"
                        + "============================================================\n\n"
                        + "  Course ID   : "
                        + courseId.getText() + "\n"
                        + "  Course Name : "
                        + courseName.getText() + "\n\n"
                        + "  Course added successfully!\n"
                        + "============================================================"
                );

                ps.close();
            }

            // ==================================================
            // VIEW COURSES
            // ==================================================

            else if (
                    e.getSource() == viewCourses) {

                Statement st =
                        con.createStatement();

                ResultSet rs =
                        st.executeQuery(
                                "SELECT * "
                                + "FROM student_registration.course");

                output.setText(
                        "============================================================\n"
                        + "                     COURSE LIST\n"
                        + "============================================================\n\n");

                boolean found = false;

                while (rs.next()) {

                    found = true;

                    output.append(
                            "  Course ID   : "
                            + rs.getInt("course_id")
                            + "\n");

                    output.append(
                            "  Course Name : "
                            + rs.getString("course_name")
                            + "\n");

                    output.append(
                            "------------------------------------------------------------\n");
                }

                if (!found) {

                    output.append(
                            "  No course records found.\n");
                }

                rs.close();

                st.close();
            }

            // ==================================================
            // REGISTER COURSE
            // ==================================================

            else if (
                    e.getSource() == registerCourse) {

                String sql =
                        "INSERT INTO "
                        + "student_registration.registration "
                        + "(student_id, course_id) "
                        + "VALUES (?, ?)";

                PreparedStatement ps =
                        con.prepareStatement(sql);

                ps.setInt(
                        1,
                        Integer.parseInt(
                                regStudentId.getText()));

                ps.setInt(
                        2,
                        Integer.parseInt(
                                regCourseId.getText()));

                ps.executeUpdate();

                output.setText(
                        "============================================================\n"
                        + "               COURSE REGISTRATION\n"
                        + "============================================================\n\n"
                        + "  Student ID : "
                        + regStudentId.getText() + "\n"
                        + "  Course ID  : "
                        + regCourseId.getText() + "\n\n"
                        + "  Registration completed successfully!\n"
                        + "============================================================"
                );

                ps.close();
            }

            // ==================================================
            // VIEW REGISTRATIONS
            // ==================================================

            else if (
                    e.getSource() == viewRegistrations) {

                Statement st =
                        con.createStatement();

                ResultSet rs =
                        st.executeQuery(
                                "SELECT * "
                                + "FROM student_registration.registration");

                output.setText(
                        "============================================================\n"
                        + "                 REGISTRATION LIST\n"
                        + "============================================================\n\n");

                boolean found = false;

                while (rs.next()) {

                    found = true;

                    output.append(
                            "  Registration ID : "
                            + rs.getInt("registration_id")
                            + "\n");

                    output.append(
                            "  Student ID      : "
                            + rs.getInt("student_id")
                            + "\n");

                    output.append(
                            "  Course ID       : "
                            + rs.getInt("course_id")
                            + "\n");

                    output.append(
                            "------------------------------------------------------------\n");
                }

                if (!found) {

                    output.append(
                            "  No registration records found.\n");
                }

                rs.close();

                st.close();
            }

            con.close();

        }

        catch (Exception ex) {

            output.setText(
                    "============================================================\n"
                    + "                         ERROR\n"
                    + "============================================================\n\n"
                    + "  Operation could not be completed.\n\n"
                    + "  Reason: "
                    + ex.getMessage() + "\n\n"
                    + "  Please check the database tables and input.\n"
                    + "============================================================"
            );
        }
    }

    // ==================================================
    // MAIN METHOD
    // ==================================================

    public static void main(
            String[] args) {

        new StudentCourseRegistrationAWT();
    }
}