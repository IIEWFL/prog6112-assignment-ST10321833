package com.mycompany.mainapp;
     import java.util.ArrayList;
import java.util.Scanner;

    
class Student {
    private int StudentId;
    private String FirstName;
    private String Surname;
    private int Age;
    
//Awati, R. (2022) What is a menu?, WhatIs.com. Available at: https://www.techtarget.com/whatis/definition/menu (Accessed: 21 September 2023). 
//Arrays in Java. (no date) Princeton University. Available at: https://introcs.cs.princeton.edu/java/14array/ (Accessed: 21 September 2023). \
//Java programming tutorial (no date) Java Basics - Java Programming Tutorial. Available at: https://www3.ntu.edu.sg/home/ehchua/programming/java/j2_basics.html (Accessed: 21 September 2023). 
//Java encapsulation: A student class with grade validation (no date) w3resource. Available at: https://www.w3resource.com/java-exercises/encapsulation/java-encapsulation-exercise-7.php (Accessed: 21 September 2023). 
//Junit tutorial (no date) Online Courses and eBooks Library. Available at: https://www.tutorialspoint.com/junit/index.htm (Accessed: 21 September 2023). 
    
    public Student(int studentId, String firstName, String lastName, int age) {
        this.StudentId = studentId;
        this.FirstName = firstName;
        this.Surname = lastName;
        this.Age = age;
    }

    public int getStudentId() {
        return StudentId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return Surname;
    }

    public int getAge() {
        return Age;
    }

    public String getFullName() {
        return FirstName + " " + Surname;
    }
}

public class Mainapp {
    private static ArrayList<Student> students = new ArrayList<>();
    private static int nextStudentId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Management Application");
        System.out.println("Enter (1) to launch menu or any other key to exit.");

        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            displayMenu(scanner);
        } else {
            System.out.println("Goodbye!");
        }
    }

    private static void displayMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new student.");
            System.out.println("(2) Search for a student.");
            System.out.println("(3) Delete a student.");
            System.out.println("(4) Print student report.");
            System.out.println("(5) Exit application.");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    captureStudent(scanner);
                    break;
                case "2":
                    searchStudent(scanner);
                    break;
                case "3":
                    deleteStudent(scanner);
                    break;
                case "4":
                    printStudentReport();
                    break;
                case "5":
                    System.out.println("Bye until next time");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid menu item.");
                    break;
            }
        }
    }

    private static void captureStudent(Scanner scanner) {
        System.out.println("\nEnter the student's First name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter the student's Surname:");
        String lastName = scanner.nextLine();

        int age;
        do {
            System.out.println("Enter the student's Age (>= 16):");
            age = validateAge(scanner.nextLine());
        } while (age < 16);

        Student student = new Student(nextStudentId, firstName, lastName, age);
        students.add(student);
        nextStudentId++;

        System.out.println("The saved student information was successful.");
    }

    private static int validateAge(String input) {
        try {
            int age = Integer.parseInt(input);
            if (age < 16) {
                System.out.println("Invalid age. Please enter a valid age (>= 16):");
                return -1;
            }
            return age;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number:");
            return -1;
        }
    }

    private static void searchStudent(Scanner scanner) {
        System.out.println("\nEnter the student's ID to search:");
        int studentIdToSearch = validateStudentId(scanner.nextLine());

        for (Student student : students) {
            if (student.getStudentId() == studentIdToSearch) {
                System.out.println("Student found:");
                System.out.println("Student ID: " + student.getStudentId());
                System.out.println("Name: " + student.getFullName());
                System.out.println("Age: " + student.getAge());
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static int validateStudentId(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid student ID:");
            return -1;
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.println("\nEnter the student's ID to delete:");
        int studentIdToDelete = validateStudentId(scanner.nextLine());

        for (Student student : students) {
            if (student.getStudentId() == studentIdToDelete) {
                System.out.println("Student found:");
                System.out.println("Student ID: " + student.getStudentId());
                System.out.println("Name: " + student.getFullName());
                System.out.println("Age: " + student.getAge());
                System.out.println("Do you want to delete this student? (yes/no)");

                String confirmDelete = scanner.nextLine().toLowerCase();
                if (confirmDelete.equals("yes")) {
                    students.remove(student);
                    System.out.println("Student deleted successfully.");
                } else {
                    System.out.println("Student not deleted.");
                }

                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static void printStudentReport() {
        if (students.isEmpty()) {
            System.out.println("No students to report.");
        } else {
            System.out.println("\nStudent Report:");
            for (Student student : students) {
                System.out.println("Student ID: " + student.getStudentId());
                System.out.println("Name: " + student.getFullName());
                System.out.println("Age: " + student.getAge());
                System.out.println();
            }
        }
    }
}

    
