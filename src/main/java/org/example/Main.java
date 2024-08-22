package org.example;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();

        while (true) {
            System.out.println("Enter 1 to launch menu or any other key to exit:");
            String input = scanner.nextLine();

            if (!input.equals("1")) {
                break;
            }
            // Student Menu for user to select an option of choice
            while (true) {
                System.out.println("Select an option:");
                System.out.println("(1) Capture a new student");
                System.out.println("(2) Search for a student");
                System.out.println("(3) Delete student");
                System.out.println("(4) Print student report");
                System.out.println("(5) Exit application");
                System.out.print("Enter your choice: ");
                input = scanner.nextLine();

                //If user enter (1) it prompts them to enter student details
                switch (input) {
                    case "1":
                        System.out.print("Enter student ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        studentManager.addStudent(new Student(id, name));
                        System.out.println("Student added successfully.");
                        break;

                        //For user to Search for an Student by ID
                    case "2":
                        System.out.print("Enter student ID to search: ");
                        id = scanner.nextLine();
                        Student student = studentManager.searchStudent(id);
                        if (student != null) {
                            System.out.println("Student found: " + student);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                        //Prompts user to delete Student details
                    case "3":
                        System.out.print("Enter student ID to delete: ");
                        id = scanner.nextLine();
                        boolean deleted = studentManager.deleteStudent(id);
                        if (deleted) {
                            System.out.println("Student deleted successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                        //Prints out Student details
                    case "4":
                        System.out.println("Student Report:");
                        studentManager.printStudentReport();
                        break;

                        //Prompts user to exit when done
                    case "5":
                        System.out.println("Exiting application.");
                        scanner.close();
                        return;

                        //If user prompts wrong display this message.
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }
}
