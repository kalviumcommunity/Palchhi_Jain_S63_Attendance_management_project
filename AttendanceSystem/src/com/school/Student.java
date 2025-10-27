package com.school;

public class Student extends Person {
    private String gradeLevel;

    // Constructor
    public Student(String name, String gradeLevel) {
        super(name);
        this.gradeLevel = gradeLevel;
    }

    public int getStudentId() {
        return id;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("Role: Student");
    }
}
