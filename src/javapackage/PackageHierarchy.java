package com.university.department.cse;

public class Course {

    String courseName;
    int courseCode;

    public Course(String name, int code) {
        courseName = name;
        courseCode = code;
    }

    public void displayCourse() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Code: " + courseCode);
    }
}import com.university.department.cse.Course;

public class MainApp {

    public static void main(String[] args) {

        Course c = new Course("Computer Science Engineering", 101);

        System.out.println("Course Details:");
        c.displayCourse();
    }
}