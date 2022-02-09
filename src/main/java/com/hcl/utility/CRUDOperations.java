package com.hcl.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hcl.entity.Student;


public class CRUDOperations {
	
	public void insertEntity(String firstName, String lastName, String email) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		Student s1 = new Student(firstName, lastName, email);
		entityManager.persist(s1);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void findEntity(int id) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Student s1 = entityManager.find(Student.class, id);
		System.out.println("\n" + s1.toString() + "\n");
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void updateEntity(int id, String firstName, String lastName, String email) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Student s1 = entityManager.find(Student.class, id);
		System.out.println(s1.toString());
		
		//entity object updates in db when transaction is committed
		s1.setFirstName(firstName);
		s1.setLastName(lastName);
		s1.setEmail(email);
		
		System.out.println("\nChanged to:\n" + s1.toString() + "\n");
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void removeEntity(int id) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Student s1 = entityManager.find(Student.class, id);
		System.out.println("\n" + s1.toString() + "\n");
		
		entityManager.remove(s1);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
//	public void retrieveAllEntities() {
//		
//		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
//		entityManager.getTransaction().begin();
//		
//		Query sList = entityManager.createQuery("SELECT * FROM student");
//		System.out.println(sList.toString());
//		//return sList;
//	}
}
