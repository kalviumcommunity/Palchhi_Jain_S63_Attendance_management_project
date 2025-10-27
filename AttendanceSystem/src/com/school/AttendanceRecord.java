package com.school;

public class AttendanceRecord {
    private int studentId;
    private int courseId;
    private String status;

    // Constructor
    public AttendanceRecord(int studentId, int courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        
        // Validation for status
        if ("Present".equalsIgnoreCase(status) || "Absent".equalsIgnoreCase(status)) {
            this.status = status;
        } else {
            this.status = "Invalid";
            System.out.println("Warning: Invalid status '" + status + "' provided. Setting status to 'Invalid'.");
        }
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getStatus() {
        return status;
    }

    // Display method
    public void displayRecord() {
        System.out.println("Attendance Record: Student ID=" + studentId + ", Course ID=" + courseId + ", Status=" + status);
    }
}