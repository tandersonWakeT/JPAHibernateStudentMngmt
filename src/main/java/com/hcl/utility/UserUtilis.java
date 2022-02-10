package com.hcl.utility;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import com.hcl.entity.Student;

/* Interactive console for the user to select which function they wish to perform
*  on the database
*/
public class UserUtilis {
	
	private static Scanner kb = new Scanner(System.in);
	private static CRUDOperations crudOp = new CRUDOperations();
	
	public static void displayMenu(){

		System.out.println("Interactive Student Database");
		System.out.println("=============================");
		
		
		int guide = 0;
		boolean flag = true;

		while (flag) {
			
			try {
				System.out.println("Enter 1 to Query\n" + "Enter 2 to Insert\n" + "Enter 3 to Update\n"
						+ "Enter 4 to Delete\n" + "Enter 5 to Display All\n" + "Enter any other key to Exit.");
				guide = kb.nextInt();
				kb.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println("Program Ended");
				flag = false;
				break;
			}

			switch (guide) {
			case 1:
				queryGuide();
				break;
			case 2:
				insertGuide();
				break;
			case 3:
				updateGuide();
				break;
			case 4:
				deleteGuide();
				break;
			case 5:
				displayAll();
				break;
			case 0:
				System.out.println("Program Ended");
				flag = false;
				break;
			default:
				System.out.println("Program Ended");
				flag = false;
			}
		}
		kb.close();
	}
	
	// Guides the user though a specific query of the employee database
	public static void queryGuide() {
		
		System.out.println("\nQuery Guide:\n");
		
		//System.out.println("Enter your query in the form of SELECT...FROM employee...;");
		//String query = kb.nextLine();
		//String query = "SELECT * FROM employee;";
		
		System.out.println("Enter the Student Id you'd like to view: ");
		int studentId = kb.nextInt();
		kb.nextLine();
		crudOp.findEntity(studentId);
		
//		System.out.println("Enter the max age: ");
//		int maxAge = kb.nextInt();
//		kb.nextLine();
//		
//		System.out.println("Enter the min age: ");
//		int minAge = kb.nextInt();
//		kb.nextLine();
//		
//		System.out.println("Enter the max salary: ");
//		int maxSal = kb.nextInt();
//		kb.nextLine(); 
//		
//		System.out.println("Enter the min salary: ");
//		int minSal = kb.nextInt();
//		kb.nextLine();
//		
//		System.out.println("Enter what letter the name starts with (0 to skip): ");
//		String starts = kb.nextLine();
//		
//		System.out.println("\nResults:\n");
//		if (starts.charAt(0) != '0') {
//			queriedEmps.stream()
//				.filter(e -> e.getAge() <= maxAge)
//				.filter(e -> e.getAge() >= minAge)
//				.filter(e -> e.getSalary() <= maxSal)
//				.filter(e -> e.getSalary() >= minSal)
//				.filter(e -> e.getEmpName().startsWith(starts.toUpperCase()))
//				.forEach(System.out::println);
//		}
//		else {
//			queriedEmps.stream()
//				.filter(e -> e.getAge() <= maxAge)
//				.filter(e -> e.getAge() >= minAge)
//				.filter(e -> e.getSalary() <= maxSal)
//				.filter(e -> e.getSalary() >= minSal)
//				.forEach(System.out::println);
//		}
		
	}
	
	// Inserts an entirely new employee into the database, EmpId is auto-assigned
	public static void insertGuide() {
		
		System.out.println("\n=====Inserting New Student=====\n");
		System.out.println("Enter the Student's First Name:");
		String firstName = kb.nextLine();
		
		System.out.println("Enter the Student's Last Name:");
		String lastName = kb.nextLine();
		
		System.out.println("Enter the Student's Email:");
		String email = kb.nextLine();
		
		crudOp.insertEntity(firstName, lastName, email);	
	}
	
	// Updates a user in the database, selected based on EmpId, all fields are required
	public static void updateGuide() {
		
		System.out.println("\n=====Update a Student=====\n");
		System.out.println("Enter the Employee to update by their EmpId: ");
		int updateId = kb.nextInt();
		kb.nextLine();
		
		System.out.println("Enter the Student's First Name:");
		String firstName = kb.nextLine();
		
		System.out.println("Enter the Student's Last Name:");
		String lastName = kb.nextLine();
		
		System.out.println("Enter the Student's Email:");
		String email = kb.nextLine();
		
		crudOp.updateEntity(updateId, firstName, lastName, email);	
	}
	
	// Removes an employee from the database, selected using EmpId
	public static void deleteGuide() {
		
		System.out.println("\n=====Deleting Student=====\n");
		
		System.out.println("Select the EmpId for the Employee you'd like to remove: ");
		int remove = kb.nextInt();
		kb.nextLine();
		
		crudOp.removeEntity(remove);
	}
	
	// Displays all Employees Information from the employee table
	public static void displayAll() {
		
		System.out.println("\nALL STUDENTS:\n");
		List<Student> queriedStudents = crudOp.retrieveAllEntities();
		
		queriedStudents.stream()
		   .forEach(System.out::println);
	}
}
