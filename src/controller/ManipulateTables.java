package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Student;

public final class ManipulateTables {

	private ManipulateTables() {
		
	}
	
	public static void createStudent(Student student) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(student);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
	
	public static void readStudent(Student student) {
		
	}
	
	public static void updateStudent(Student student) {
		
	}
	
	public static void deleteStudent(Student student) {
		
	}
}
