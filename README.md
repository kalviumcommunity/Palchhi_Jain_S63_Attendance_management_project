# Palchhi_Jain_S63_Attendance_management_project

# Attendance Management System

## Project Overview
A simple Java-based project for learning purposes.

## How to Compile and Run (Part 1)
- Navigate to project root.
- Compile:
  ```bash
  javac AttendanceSystem/src/com/school/Main.java
  ```
- Run:
  ```bash
  java -cp AttendanceSystem/src com.school.Main
  ```3
  

## Part 2 Updates
- **New classes**: `Student.java`, `Course.java` in `AttendanceSystem/src/com/school/`.
- **Main.java** now demonstrates arrays of `Student` and `Course`, enrollment, and simple attendance marking.

### Compile (Part 2)
```bash
javac AttendanceSystem/src/com/school/Student.java \
      AttendanceSystem/src/com/school/Course.java \
      AttendanceSystem/src/com/school/Main.java
```

### Run
```bash
java -cp AttendanceSystem/src com.school.Main
```

### Expected Output (example)
```
Welcome to Attendance Management System!

Course Rosters:
CS101 - Intro to CS (3/ 5)
  1. Student{id=1, name='Alice', attendance%=100.0}
  2. Student{id=2, name='Bob', attendance%=0.0}
  3. Student{id=3, name='Charlie', attendance%=100.0}

MATH201 - Discrete Math (2/ 5)
  1. Student{id=1, name='Alice', attendance%=100.0}
  2. Student{id=3, name='Charlie', attendance%=100.0}

### Part 3 - Constructor Initialization & Auto-ID Generation
- Implemented constructors for Student and Course classes.
- Automatic unique ID generation using static counters.
- Demonstrated creation of multiple instances showing sequential ID generation.

## Part 4 - Data Encapsulation, Inheritance & Attendance Recording Validation

### Features Implemented:

1. **Inheritance Structure**:
   - Created `Person.java` as the base class with:
     - Private static counter for auto-increment IDs
     - Protected fields: `id`, `name`
     - Constructor with auto-incrementing ID generation
     - Getters: `getId()`, `getName()`
     - `displayDetails()` method
   
   - `Student.java` now extends `Person`:
     - Added `gradeLevel` field
     - Constructor: `super(name)` with gradeLevel initialization
     - Overridden `displayDetails()` with grade and role information
   
   - Created `Teacher.java` extending `Person`:
     - Field: `subjectTaught`
     - Constructor: `super(name)` with subject initialization
     - Overridden `displayDetails()` with subject and role information
   
   - Created `Staff.java` extending `Person`:
     - Field: `role`
     - Constructor: `super(name)` with role initialization
     - Overridden `displayDetails()` with staff role information

2. **Encapsulation**:
   - Student and Course classes have private fields with public getters
   - AttendanceRecord class with proper encapsulation and validation

3. **Attendance Recording Validation**:
   - Created `AttendanceRecord.java` with:
     - Private fields: `studentId`, `courseId`, `status`
     - Status validation: accepts only "Present" or "Absent" (case-insensitive)
     - Invalid statuses are flagged as "Invalid" with a warning message
     - Public getters for all fields
     - `displayRecord()` method for displaying attendance records

### Compile (Part 4)
```bash
javac AttendanceSystem/src/com/school/Person.java \
      AttendanceSystem/src/com/school/Student.java \
      AttendanceSystem/src/com/school/Teacher.java \
      AttendanceSystem/src/com/school/Staff.java \
      AttendanceSystem/src/com/school/Course.java \
      AttendanceSystem/src/com/school/AttendanceRecord.java \
      AttendanceSystem/src/com/school/Main.java
```

### Run (Part 4)
```bash
java -cp AttendanceSystem/src com.school.Main
```

### Expected Output (Part 4)
```
=== Students ===
ID: 1
Name: Alice
Grade Level: Grade 10
Role: Student

ID: 2
Name: Bob
Grade Level: Grade 10
Role: Student

ID: 3
Name: Charlie
Grade Level: Grade 11
Role: Student

=== Teachers ===
ID: 4
Name: Mr. Smith
Subject Taught: Mathematics
Role: Teacher

ID: 5
Name: Ms. Johnson
Subject Taught: Computer Science
Role: Teacher

=== Staff ===
ID: 6
Name: John Doe
Staff Role: Librarian
Role: Staff

ID: 7
Name: Jane Wilson
Staff Role: Administrator
Role: Staff

=== Courses ===
Course ID: C101
Course Name: Mathematics

Course ID: C102
Course Name: Computer Science

Course ID: C103
Course Name: Physics

Warning: Invalid status 'Late' provided. Setting status to 'Invalid'.

=== Attendance Records ===
Attendance Record: Student ID=1, Course ID=101, Status=Present
Attendance Record: Student ID=2, Course ID=101, Status=Absent
Attendance Record: Student ID=3, Course ID=102, Status=Present
Attendance Record: Student ID=1, Course ID=103, Status=Invalid
```