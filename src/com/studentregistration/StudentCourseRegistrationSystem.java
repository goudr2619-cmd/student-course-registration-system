package com.studentregistration;

import java.util.Scanner;

public class StudentCourseRegistrationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        RegistrationDAO registrationDAO = new RegistrationDAO();

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println(" STUDENT COURSE REGISTRATION SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Add New Course");
            System.out.println("4. View All Courses");
            System.out.println("5. Register Student for Course");
            System.out.println("6. View Courses Registered by Student");
            System.out.println("7. View Students Registered for Course");
            System.out.println("8. Update Student Information");
            System.out.println("9. Remove Student");
            System.out.println("10. Remove Course");
            System.out.println("11. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter department: ");
                    String department = sc.nextLine();

                    Student student =
                        new Student(name, email, phone, department);

                    studentDAO.addStudent(student);

                    break;

                case 2:

                    studentDAO.viewStudents();

                    break;

                case 3:

                    System.out.print("Enter course name: ");
                    String courseName = sc.nextLine();

                    System.out.print("Enter duration: ");
                    String duration = sc.nextLine();

                    System.out.print("Enter fee: ");
                    double fee = sc.nextDouble();

                    Course course =
                        new Course(courseName, duration, fee);

                    courseDAO.addCourse(course);

                    break;

                case 4:

                    courseDAO.viewCourses();

                    break;

                case 5:

                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();

                    System.out.print("Enter Course ID: ");
                    int courseId = sc.nextInt();

                    registrationDAO.registerStudent(
                        studentId, courseId);

                    break;

                case 6:

                    System.out.print("Enter Student ID: ");
                    studentId = sc.nextInt();

                    registrationDAO.viewCoursesByStudent(studentId);

                    break;

                case 7:

                    System.out.print("Enter Course ID: ");
                    courseId = sc.nextInt();

                    registrationDAO.viewStudentsByCourse(courseId);

                    break;

                case 8:

                    System.out.print("Enter Student ID: ");
                    studentId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    name = sc.nextLine();

                    System.out.print("Enter new email: ");
                    email = sc.nextLine();

                    System.out.print("Enter new phone: ");
                    phone = sc.nextLine();

                    System.out.print("Enter new department: ");
                    department = sc.nextLine();

                    studentDAO.updateStudent(
                        studentId,
                        name,
                        email,
                        phone,
                        department
                    );

                    break;

                case 9:

                    System.out.print("Enter Student ID: ");
                    studentId = sc.nextInt();

                    studentDAO.removeStudent(studentId);

                    break;

                case 10:

                    System.out.print("Enter Course ID: ");
                    courseId = sc.nextInt();

                    courseDAO.removeCourse(courseId);

                    break;

                case 11:

                    System.out.println("Thank you for using the system.");

                    break;

                default:

                    System.out.println("Invalid choice.");

            }

        } while (choice != 11);

        sc.close();
    }
}