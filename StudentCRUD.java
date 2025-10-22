package com.student;

import java.util.*;
public class StudentCRUD 
{
	 private static ArrayList<Student> students = new ArrayList<>();
	 private static Scanner sc = new Scanner(System.in);

	 public static void main(String[] args) 
	 {
	    int choice;
	        do {
	            System.out.println("\nStudent Record Management");
	            System.out.println("1. Add Student");
	            System.out.println("2. View Students");
	            System.out.println("3. Update Student");
	            System.out.println("4. Delete Student");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();

	            switch (choice) 
	            {
	                case 1 -> addStudent();
	                case 2 -> viewStudents();
	                case 3 -> updateStudent();
	                case 4 -> deleteStudent();
	                case 5 -> System.out.println("Exit");
	                default -> System.out.println("Invalid choice");
	            }
	        } 
	        while (choice != 5);
	    }

	    private static void addStudent() 
	    {
	        System.out.print("Enter ID: ");
	        int id = sc.nextInt();
	        sc.nextLine(); 
	        System.out.print("Enter Name: ");
	        String name = sc.nextLine();
	        System.out.print("Enter Marks: ");
	        double marks = sc.nextDouble();
	        students.add(new Student(id, name, marks));
	        System.out.println("Student added successfully\n");
	    }

	    private static void viewStudents() 
	    {
	        if (students.isEmpty()) {
	            System.out.println("No records found\n");
	            return;
	        }
	        System.out.println("\nStudent List");
	        for (Student s : students) {
	            System.out.println(s);
	        }
	        System.out.println("Students viewed successfully\n");
	    }

	    private static void updateStudent() 
	    {
	        System.out.print("Enter student ID to update: ");
	        int id = sc.nextInt();
	        sc.nextLine();
	        for (Student s : students) {
	            if (s.getId() == id) {
	                System.out.print("Enter new name: ");
	                String name = sc.nextLine();
	                System.out.print("Enter new marks: ");
	                double marks = sc.nextDouble();
	                s.setName(name);
	                s.setMarks(marks);
	                System.out.println("Student record updated successfully\n");
	                return;
	            }
	        }
	        System.out.println("Student not found\n");
	    }

	    private static void deleteStudent() 
	    {
	        System.out.print("Enter student ID to delete: ");
	        int id = sc.nextInt();
	        Iterator<Student> iterator = students.iterator();
	        while (iterator.hasNext()) {
	            Student s = iterator.next();
	            if (s.getId() == id) {
	                iterator.remove();
	                System.out.println("Student deleted successfully\n");
	                return;
	            }
	        }
	        System.out.println("Student not found\n");
	    }
}
