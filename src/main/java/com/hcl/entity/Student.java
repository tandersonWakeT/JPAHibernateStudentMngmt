package com.hcl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	/* 
	* no-arg constructor so hibernate can create instance of Persistance class
	* using newInstance() method
	*/
	public Student() {
		
	}
	
	public Student(String firstName, String lastName, String email) {
		
		//id is auto-generated
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public int getId() {
		
		return this.id;
	}
	
	public String getFirstName() {
		
		return this.firstName;
	}
	
	public String getLastName() {
	
		return this.lastName;
	}
	
	public String getEmail() {
		
		return this.email;
	}
	
	public void setId(int id) {
		
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
	
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		
		this.email = email;
	}
	
	public String toString() {
		
		return "Student ID: " + this.id + "\nFirst Name: " + this.firstName + "\nLastName: "
				+ this.lastName + "\nEmail: " + this.email;
	}
}
