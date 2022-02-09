package com.hcl.utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Optional;

public class JPAUtil {
	
	private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
	private static EntityManagerFactory factory;
	
	//private static Optional<EntityManagerFactory> optFactory = Optional.of(factory);
	
	public static EntityManagerFactory getEntityManagerFactory() {
		
		
		
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		//optFactory.
		return factory;
		
	}
	
	public static void shutdown() {
		
		if (factory != null) {
			
			factory.close();
		}
		//optFactory.ifPresent(EntityManagerFactory::close);
	}
}
