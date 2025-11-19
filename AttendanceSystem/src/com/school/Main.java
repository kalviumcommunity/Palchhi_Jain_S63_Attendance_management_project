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

        // Attendance Recording
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Create AttendanceRecord objects using Student and Course objects
        AttendanceRecord ar1 = new AttendanceRecord(s1, c1, "Present");
        AttendanceRecord ar2 = new AttendanceRecord(s2, c1, "Absent");
        AttendanceRecord ar3 = new AttendanceRecord(s3, c2, "Present");
        AttendanceRecord ar4 = new AttendanceRecord(s1, c3, "Late");  // Invalid status

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

        // File Storage
        System.out.println("\n=== Saving Data to Files ===");
        
        // Create ArrayLists for storage
        // Prepare students list by filtering schoolPeople (demonstrates instanceof and casting)
        List<Student> students = new ArrayList<>();
        for (Person p : schoolPeople) {
            if (p instanceof Student) {
                students.add((Student) p);
            }
        }

        List<Course> courses = new ArrayList<>();
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);

        // Create FileStorageService and save data
        FileStorageService storageService = new FileStorageService();
        storageService.saveData(students, "students.txt");
        storageService.saveData(courses, "courses.txt");
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}
