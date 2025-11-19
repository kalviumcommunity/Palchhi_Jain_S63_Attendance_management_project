package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n=== School Directory ===");
        for (Person person : people) {
            person.displayDetails();
            System.out.println();
        }
    }

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

        // Build school people list and demonstrate polymorphic directory display
        List<Person> schoolPeople = new ArrayList<>();
        schoolPeople.add(s1);
        schoolPeople.add(s2);
        schoolPeople.add(s3);
        schoolPeople.add(t1);
        schoolPeople.add(t2);
        schoolPeople.add(staff1);
        schoolPeople.add(staff2);

        displaySchoolDirectory(schoolPeople);

        // Prepare students and courses lists
        List<Student> allStudents = new ArrayList<>();
        for (Person p : schoolPeople) {
            if (p instanceof Student) {
                allStudents.add((Student) p);
            }
        }
        List<Course> allCourses = new ArrayList<>();
        allCourses.add(c1);
        allCourses.add(c2);
        allCourses.add(c3);

        // Create FileStorageService and AttendanceService
        FileStorageService storageService = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storageService);

        // Mark attendance using overloaded methods
        attendanceService.markAttendance(s1, c1, "Present");
        attendanceService.markAttendance(s2, c1, "Absent");
        attendanceService.markAttendance(s3, c2, "Present");
        attendanceService.markAttendance(s1, c3, "Late"); // Invalid status

        // Mark attendance using IDs and lookup
        attendanceService.markAttendance(s2.getId(), c2.getCourseId(), "Present", allStudents, allCourses);
        attendanceService.markAttendance(s3.getId(), c3.getCourseId(), "Absent", allStudents, allCourses);

        // Display all attendance records
        attendanceService.displayAttendanceLog();

        // Display attendance for a specific student
        attendanceService.displayAttendanceLog(s1);

        // Display attendance for a specific course
        attendanceService.displayAttendanceLog(c1);

        // Save attendance log to file
        attendanceService.saveAttendanceData();

        // Save students and courses as before
        storageService.saveData(allStudents, "students.txt");
        storageService.saveData(allCourses, "courses.txt");
    }
}
