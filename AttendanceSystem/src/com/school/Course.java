package com.school;

public class Course implements Storable {
    private static int nextCourseIdCounter = 101;  // starts from 101
    private int courseId;
    private String courseName;

    // Constructor
    public Course(String courseName) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayDetails() {
        System.out.println("Course ID: C" + courseId);
        System.out.println("Course Name: " + courseName);
    }

    @Override
    public String toDataString() {
        return courseId + "," + courseName;
    }
}
