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

        // Create Courses
        Course c1 = regService.createCourse("Mathematics");
        Course c2 = regService.createCourse("Computer Science");
        Course c3 = regService.createCourse("Physics");

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

        // Display Course Details
        System.out.println("\n=== Courses ===");
        c1.displayDetails();
        System.out.println();
        c2.displayDetails();
        System.out.println();
        c3.displayDetails();

        // Display school directory using RegistrationService (polymorphic)
        displaySchoolDirectory(regService);

        // Create AttendanceService with injected RegistrationService
        AttendanceService attendanceService = new AttendanceService(storageService, regService);

        // Mark attendance using ID-based overloaded method (uses RegistrationService lookups)
        attendanceService.markAttendance(s1.getId(), c1.getCourseId(), "Present");
        attendanceService.markAttendance(s2.getId(), c1.getCourseId(), "Absent");
        attendanceService.markAttendance(s3.getId(), c2.getCourseId(), "Present");
        attendanceService.markAttendance(s1.getId(), c3.getCourseId(), "Late"); // Invalid status

        // Additional ID-based markings
        attendanceService.markAttendance(s2.getId(), c2.getCourseId(), "Present");
        attendanceService.markAttendance(s3.getId(), c3.getCourseId(), "Absent");

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
