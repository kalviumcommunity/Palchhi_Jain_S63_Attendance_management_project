package com.school;

public class Course {
    private final String code;
    private final String title;
    private final Student[] students;
    private int count = 0;

    public Course(String code, String title, int capacity) {
        this.code = code;
        this.title = title;
        this.students = new Student[capacity];
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public Student[] getStudents() { return students; }
    public int getCount() { return count; }

    /**
     * Enroll a student if capacity allows.
     * @return true if enrolled
     */
    public boolean enrollStudent(Student s) {
        if (count >= students.length) return false;
        students[count++] = s;
        return true;
    }

    public String roster() {
        StringBuilder sb = new StringBuilder();
        sb.append(code).append(" - ").append(title).append(" (" ).append(count).append("/ ").append(students.length).append(")\n");
        for (int i = 0; i < count; i++) {
            sb.append("  ").append(i + 1).append(". ").append(students[i]).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", enrolled=" + count +
                "/" + students.length +
                '}';
    }
}