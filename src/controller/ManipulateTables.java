package controller;

import javax.persistence.EntityManager;

import model.Student;

public final class ManipulateTables {

	private ManipulateTables() {

	}
	
	public static void createStudent(EntityManager manager, Student student) {
		manager.getTransaction().begin();
		manager.persist(student);
		manager.getTransaction().commit();
	}
	
	public static void readStudent(Student student) {
		
	}
	
	public static void updateStudent(Student student) {
		
	}
	
	public static void deleteStudent(Student student) {
		
	}
}
