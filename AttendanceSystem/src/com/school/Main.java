package com.school;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Attendance Management System!");

        Student[] students = new Student[]{
                new Student(1, "Alice", 5),
                new Student(2, "Bob", 5),
                new Student(3, "Charlie", 5)
        };

        students[0].markAttendance(0, true);
        students[0].markAttendance(1, true);
        students[1].markAttendance(0, false);
        students[2].markAttendance(0, true);

        Course course1 = new Course("CS101", "Intro to CS", 5);
        Course course2 = new Course("MATH201", "Discrete Math", 5);

     
        for (Student s : students) {
            course1.enrollStudent(s);
        }
        course2.enrollStudent(students[0]);
        course2.enrollStudent(students[2]);

    
        System.out.println("\nCourse Rosters:");
        System.out.println(course1.roster());
        System.out.println(course2.roster());
    }
}
