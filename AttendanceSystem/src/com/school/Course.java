public class Course {
    private static int nextCourseIdCounter = 101;  // starts from 101
    private int courseId;
    private String courseName;

    // Constructor
    public Course(String courseName) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseName;
    }

    public void displayDetails() {
        System.out.println("Course ID: C" + courseId);
        System.out.println("Course Name: " + courseName);
    }
}
