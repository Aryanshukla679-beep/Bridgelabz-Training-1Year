// Student class in college.student package
package college.student;

public class Student {
    String name;
    int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public void displayStudent() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNo);
    }
}


// Faculty class in college.faculty package
package college.faculty;

public class Faculty {
    String name;
    String subject;

    public Faculty(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void displayFaculty() {
        System.out.println("Faculty Name: " + name);
        System.out.println("Subject: " + subject);
    }
}


// Main class (not in any package)
import college.student.Student;
import college.faculty.Faculty;

public class MainClass {

    public static void main(String[] args) {

        Student s = new Student("Aryan Shukla", 101);
        Faculty f = new Faculty("Dr. Sharma", "Computer Science");

        System.out.println("Student Details:");
        s.displayStudent();

        System.out.println();

        System.out.println("Faculty Details:");
        f.displayFaculty();
    }
}