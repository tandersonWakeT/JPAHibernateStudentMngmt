package com.hcl;

import com.hcl.utility.CRUDOperations;
import com.hcl.utility.UserUtilis;
/**
 * Program Assignment:
 * 		
 * Create a Student table in MySQL with columns:
 * 						1. id
 * 						2. first_name
 * 						3. last_name
 * 						4. email
 * 
 * Use Hibernate with JPA to achieve the following functionality:
 * 						A. Insert a record into the table
 * 						B. Find a particular row data specific to a student Id
 * 						C. Find all the student's data
 * 						D. Update a particular row with the given Id
 * 						E. Delete a row with the given Id
 */
public class StudentMngmtCLI {
	
    public static void main(String[] args) {
    	
    	UserUtilis.displayMenu();
//    	CRUDOperations crudOp = new CRUDOperations();
//    	crudOp.insertEntity();
//    	crudOp.findEntity();
//    	crudOp.updateEntity();
//    	crudOp.removeEntity();
    }
}
