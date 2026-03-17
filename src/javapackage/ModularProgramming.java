// File: src/collegeinfo/college/student/Student.java
package javapackage;

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
}// File: src/collegeinfo/module-info.java
module collegeinfo {
    exports college.student;
}// File: src/app/MainApp.java
import college.student.Student;

        public class MainApp {

        public static void main(String[] args) {

        Student s = new Student("Aryan Shukla", 101);
        s.displayStudent();
        }
        }