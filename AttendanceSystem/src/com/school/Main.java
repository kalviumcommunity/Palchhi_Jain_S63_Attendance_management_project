package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n=== School Directory ===");
        for (Person person : regService.getAllPeople()) {
            person.displayDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create FileStorageService and RegistrationService
        FileStorageService storageService = new FileStorageService();
        RegistrationService regService = new RegistrationService(storageService);

        // Register Students
        Student s1 = regService.registerStudent("Alice", "Grade 10");
        Student s2 = regService.registerStudent("Bob", "Grade 10");
        Student s3 = regService.registerStudent("Charlie", "Grade 11");

        // Register Teachers
        Teacher t1 = regService.registerTeacher("Mr. Smith", "Mathematics");
        Teacher t2 = regService.registerTeacher("Ms. Johnson", "Computer Science");

        // Register Staff
        Staff staff1 = regService.registerStaff("John Doe", "Librarian");
        Staff staff2 = regService.registerStaff("Jane Wilson", "Administrator");

        // Create Courses with capacities
        Course c1 = regService.createCourse("Mathematics", 2);
        Course c2 = regService.createCourse("Computer Science", 2);
        Course c3 = regService.createCourse("Physics", 1);

        // Display Student Details
        System.out.println("=== Students ===");
        s1.displayDetails();
        System.out.println();
        s2.displayDetails();
        System.out.println();
        s3.displayDetails();

        // Display Teacher Details
        System.out.println("\n=== Teachers ===");
        t1.displayDetails();
        System.out.println();
        t2.displayDetails();

        // Display Staff Details
        System.out.println("\n=== Staff ===");
        staff1.displayDetails();
        System.out.println();
        staff2.displayDetails();

        // Display Course Details (initial)
        System.out.println("=== Courses (initial) ===");
        c1.displayDetails();
        System.out.println();
        c2.displayDetails();
        System.out.println();
        c3.displayDetails();

        // Display school directory using RegistrationService (polymorphic)
        displaySchoolDirectory(regService);


        // Enroll students (respecting capacity) and demonstrate over-capacity attempt
        regService.enrollStudentInCourse(s1, c1); // should succeed
        regService.enrollStudentInCourse(s2, c1); // should succeed
        regService.enrollStudentInCourse(s3, c1); // should fail (capacity 2)

        regService.enrollStudentInCourse(s2, c2); // should succeed
        regService.enrollStudentInCourse(s3, c2); // should succeed

        regService.enrollStudentInCourse(s1, c3); // should succeed (capacity 1)
        regService.enrollStudentInCourse(s2, c3); // should fail (capacity reached)

        // Display Course Details after enrollment
        System.out.println("\n=== Courses (after enrollment) ===");
        c1.displayDetails();
        System.out.println();
        c2.displayDetails();
        System.out.println();
        c3.displayDetails();

        // Create AttendanceService with injected RegistrationService
        AttendanceService attendanceService = new AttendanceService(storageService, regService);

        // Mark attendance using ID-based overloaded method (uses RegistrationService lookups)
        // Only mark attendance if student is enrolled in the course
        if (c1.getEnrolledStudents().contains(s1)) attendanceService.markAttendance(s1.getId(), c1.getCourseId(), "Present");
        else System.out.println(s1.getName() + " is not enrolled in " + c1.getCourseName());

        if (c1.getEnrolledStudents().contains(s2)) attendanceService.markAttendance(s2.getId(), c1.getCourseId(), "Absent");
        else System.out.println(s2.getName() + " is not enrolled in " + c1.getCourseName());

        if (c2.getEnrolledStudents().contains(s3)) attendanceService.markAttendance(s3.getId(), c2.getCourseId(), "Present");
        else System.out.println(s3.getName() + " is not enrolled in " + c2.getCourseName());

        if (c3.getEnrolledStudents().contains(s1)) attendanceService.markAttendance(s1.getId(), c3.getCourseId(), "Late");
        else System.out.println(s1.getName() + " is not enrolled in " + c3.getCourseName());

        // Additional ID-based markings
        if (c2.getEnrolledStudents().contains(s2)) attendanceService.markAttendance(s2.getId(), c2.getCourseId(), "Present");
        if (c3.getEnrolledStudents().contains(s3)) attendanceService.markAttendance(s3.getId(), c3.getCourseId(), "Absent");

        // Display all attendance records
        attendanceService.displayAttendanceLog();

        // Display attendance for a specific student
        attendanceService.displayAttendanceLog(s1);

        // Display attendance for a specific course
        attendanceService.displayAttendanceLog(c1);

        // Persist registrations and attendance
        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();
    }
}
