package com.school;

public class AttendanceRecord implements Storable {
    private Student student;
    private Course course;
    private String status;

    // Constructor accepts Student and Course objects
    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;

        // Validation for status
        if ("Present".equalsIgnoreCase(status) || "Absent".equalsIgnoreCase(status)) {
            this.status = status;
        } else {
            this.status = "Invalid";
            System.out.println("Warning: Invalid status '" + status + "' provided. Setting status to 'Invalid'.");
        }
    }

    // Getters return the associated objects
    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    // Display method uses richer object data
    public void displayRecord() {
        System.out.println("Attendance Record: Student ID=" + student.getId()
                + ", Name=" + student.getName()
                + ", Course ID=" + course.getCourseId()
                + ", Course=" + course.getCourseName()
                + ", Status=" + status);
    }

    @Override
    public String toDataString() {
        // Keep CSV format for file storage: studentId,courseId,status
        return student.getId() + "," + course.getCourseId() + "," + status;
    }
}