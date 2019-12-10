package controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BuildTables {
	
	public BuildTables() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student");
		factory.close();
	}
}
