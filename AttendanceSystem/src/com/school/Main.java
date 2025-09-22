package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating Students
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Charlie");

        // Creating Courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Computer Science");
        Course c3 = new Course("Physics");

        // Display Student Details
        System.out.println("=== Students ===");
        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();

        // Display Course Details
        System.out.println("\n=== Courses ===");
        c1.displayDetails();
        c2.displayDetails();
        c3.displayDetails();

        // Attendance Recording
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Create AttendanceRecord objects
        AttendanceRecord ar1 = new AttendanceRecord(s1.getStudentId(), c1.getCourseId(), "Present");
        AttendanceRecord ar2 = new AttendanceRecord(s2.getStudentId(), c1.getCourseId(), "Absent");
        AttendanceRecord ar3 = new AttendanceRecord(s3.getStudentId(), c2.getCourseId(), "Present");
        AttendanceRecord ar4 = new AttendanceRecord(s1.getStudentId(), c3.getCourseId(), "Late");  // Invalid status

        // Add to log
        attendanceLog.add(ar1);
        attendanceLog.add(ar2);
        attendanceLog.add(ar3);
        attendanceLog.add(ar4);

        // Display attendance records
        System.out.println("\n=== Attendance Records ===");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
