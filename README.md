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

## Part 6 - Generics & File Storage with Storable Interface

### Features Implemented:

1. **Storable Interface**:
   - Created `Storable.java` interface in `src/com/school/`
   - Defines contract: `String toDataString();`
   - Enables polymorphic data serialization

2. **Interface Implementation**:
   - `Student.java` implements `Storable`:
     - `toDataString()` returns: `id,name,gradeLevel`
   
   - `Course.java` implements `Storable`:
     - `toDataString()` returns: `courseId,courseName`
   
   - `AttendanceRecord.java` implements `Storable`:
     - `toDataString()` returns: `studentId,courseId,status`

3. **Generic File Storage Service**:
   - Created `FileStorageService.java` with:
     - Method: `public void saveData(List<? extends Storable> items, String filename)`
     - Accepts any List of Storable objects (uses wildcard generics)
     - Uses try-with-resources for FileWriter and PrintWriter
     - Iterates through items, calling `toDataString()`, and writes each line
     - Includes error handling for IOException

4. **Main.java Updates**:
   - Creates `ArrayList<Student>` and populates with student objects
   - Creates `ArrayList<Course>` and populates with course objects
   - Creates `FileStorageService` instance
   - Calls `saveData()` to save:
     - Students to `students.txt`
     - Courses to `courses.txt`
     - Attendance records to `attendance_log.txt`

### Compile (Part 6)
```bash
javac AttendanceSystem/src/com/school/Storable.java \
      AttendanceSystem/src/com/school/Person.java \
      AttendanceSystem/src/com/school/Student.java \
      AttendanceSystem/src/com/school/Teacher.java \
      AttendanceSystem/src/com/school/Staff.java \
      AttendanceSystem/src/com/school/Course.java \
      AttendanceSystem/src/com/school/AttendanceRecord.java \
      AttendanceSystem/src/com/school/FileStorageService.java \
      AttendanceSystem/src/com/school/Main.java
```

### Run (Part 6)
```bash
java -cp AttendanceSystem/src com.school.Main
```

### Output Files Generated

After running the program, three CSV files are created in the project root:

**students.txt** - Student data in CSV format
```
1,Alice,Grade 10
2,Bob,Grade 10
3,Charlie,Grade 11
```

**courses.txt** - Course data in CSV format
```
101,Mathematics
102,Computer Science
103,Physics
```

**attendance_log.txt** - Attendance records in CSV format
```
1,101,Present
2,101,Absent
3,102,Present
1,103,Invalid
```

### Key Concepts Demonstrated

- **Generics**: Wildcard type `List<? extends Storable>` for flexible data handling
- **Polymorphism**: Different classes implementing same interface with different data formats
- **Try-with-resources**: Automatic resource management for file operations
- **Error Handling**: IOException handling for file operations
- **CSV Format**: Simple comma-separated values for data persistence
- **Separation of Concerns**: FileStorageService handles all file I/O logic separately
 
## Part 7 - Polymorphism in Person Hierarchy & Improved Attendance Display

### Features Implemented:

- **Polymorphic Directory Display**: Added `displaySchoolDirectory(List<Person> people)` in `Main.java` that calls `displayDetails()` on each `Person` instance so `Student`, `Teacher`, and `Staff` are displayed via runtime polymorphism.
- **AttendanceRecord Refactor**: `AttendanceRecord` now stores `Student` and `Course` references (not primitive IDs). `displayRecord()` presents richer information using `student.getName()` and `course.getCourseName()`, while `toDataString()` still outputs `studentId,courseId,status` for file persistence.
- **Filtering for Storage**: Demonstrates filtering `schoolPeople` with `instanceof` to build a `List<Student>` before calling `FileStorageService.saveData(...)`.

### Compile (Part 7)
```bash
javac AttendanceSystem/src/com/school/*.java
```

### Run (Part 7)
```bash
java -cp AttendanceSystem/src com.school.Main
```

### Expected Output Changes
- A new `=== School Directory ===` section showing `displayDetails()` output for students, teachers, and staff (polymorphic behavior).
- `=== Attendance Records ===` now shows richer lines such as:
```
Attendance Record: Student ID=1, Name=Alice, Course ID=101, Course=Mathematics, Status=Present
```

### Git Workflow Notes (Part 7)
Follow these commands to create the `part-07` branch, push, and create a PR:

```bash
git checkout -b part-07
git add .
git commit -m "feat: Demonstrate polymorphism with Person hierarchy and update AttendanceRecord (Part 7)"
git push -u origin part-07
```

Then create a PR on GitHub from `part-07` into `main` and merge per your process.

## Part 8 - AttendanceService Overloading & Querying

### Features Implemented:

- **AttendanceService**: New class with overloaded `markAttendance` methods (by object and by ID), helper lookup methods, and multiple `displayAttendanceLog` methods (all, by student, by course).
- **Main.java**: Demonstrates all overloaded methods, shows attendance logs for all, per student, and per course, and saves attendance data using the service.

### Compile (Part 8)
```bash
javac AttendanceSystem/src/com/school/*.java
```

### Run (Part 8)
```bash
java -cp AttendanceSystem/src com.school.Main
```

### Expected Output Changes
- Attendance log displays for all, for a specific student, and for a specific course.
- Attendance marking via both object and ID-based methods.
- `attendance_log.txt` updated with all records.

### Git Workflow Notes (Part 8)
Follow these commands to commit and push your changes:

```bash
git add .
git commit -m "feat: Add AttendanceService with overloaded methods and log querying (Part 8)"
git push -u origin part-08
```

Then create a PR on GitHub from `part-08` into `main` and merge per your process.

## Part 9 - RegistrationService & SRP Improvements

### Features Implemented:

- **RegistrationService**: New `RegistrationService.java` that centralizes creation and management of `Student`, `Teacher`, `Staff`, and `Course` lists. It depends on `FileStorageService` to persist the lists.
- **Storable Support**: `Teacher` and `Staff` now implement `Storable` and provide `toDataString()` so they can be saved by `FileStorageService` like `Student` and `Course`.
- **AttendanceService Refactor**: `AttendanceService` now depends on `RegistrationService` for lookups; the ID-based `markAttendance(int studentId, int courseId, String status)` uses the registration service to resolve objects.
- **Main.java Update**: `Main` now creates `FileStorageService`, `RegistrationService`, and `AttendanceService` (with DI). Registrations are done via `regService.registerStudent(...)`, `registerTeacher(...)`, `registerStaff(...)`, `createCourse(...)`. Attendance is recorded via ID-based `markAttendance(...)` and persisted via `regService.saveAllRegistrations()` and `attendanceService.saveAttendanceData()`.

### Compile (Part 9)
```bash
javac AttendanceSystem/src/com/school/*.java
```

### Run (Part 9)
```bash
java -cp AttendanceSystem/src com.school.Main
```

### Expected Output & Files
- Console output demonstrating registrations, the school directory (polymorphic), and attendance logs.
- New/updated files generated in the project root: `students.txt`, `teachers.txt`, `staff.txt`, `courses.txt`, and `attendance_log.txt`.

### Git Workflow Notes (Part 9)
```bash
git add .
git commit -m "feat: Apply SRP with RegistrationService and refined AttendanceService (Part 9)"
git push -u origin part-09
```

Then create a PR on GitHub from `part-09` into `main` and follow your merge process.