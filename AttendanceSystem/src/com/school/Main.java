package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating Students
        Student s1 = new Student("Alice", "Grade 10");
        Student s2 = new Student("Bob", "Grade 10");
        Student s3 = new Student("Charlie", "Grade 11");

        // Creating Teachers
        Teacher t1 = new Teacher("Mr. Smith", "Mathematics");
        Teacher t2 = new Teacher("Ms. Johnson", "Computer Science");

        // Creating Staff
        Staff staff1 = new Staff("John Doe", "Librarian");
        Staff staff2 = new Staff("Jane Wilson", "Administrator");

        // Creating Courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Computer Science");
        Course c3 = new Course("Physics");

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

        // Attendance Recording
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Create AttendanceRecord objects using student.getId()
        AttendanceRecord ar1 = new AttendanceRecord(s1.getId(), c1.getCourseId(), "Present");
        AttendanceRecord ar2 = new AttendanceRecord(s2.getId(), c1.getCourseId(), "Absent");
        AttendanceRecord ar3 = new AttendanceRecord(s3.getId(), c2.getCourseId(), "Present");
        AttendanceRecord ar4 = new AttendanceRecord(s1.getId(), c3.getCourseId(), "Late");  // Invalid status

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
