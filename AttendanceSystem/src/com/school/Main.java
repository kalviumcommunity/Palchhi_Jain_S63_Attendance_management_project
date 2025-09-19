public class Main {
    public static void main(String[] args) {
        // Creating Students
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Charlie");

        // Creating Courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Computer Science");
        Course c3 = new Course("Physics");

        // Display Student Details
        System.out.println("=== Students ===");
        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();

        // Display Course Details
        System.out.println("\n=== Courses ===");
        c1.displayDetails();
        c2.displayDetails();
        c3.displayDetails();
    }
}
