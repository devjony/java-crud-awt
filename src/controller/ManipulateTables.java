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
	
	public static Student readStudent(EntityManager manager, String stringId) {
		Long longId = Long.parseLong(stringId);
		return manager.find(Student.class, longId);
	}
	
	public static void updateStudent(EntityManager manager, Student student) {
		manager.getTransaction().begin();
		manager.merge(student);
		manager.getTransaction().commit();
	}
	
	public static void deleteStudent(EntityManager manager, Long longId) {
		
		Student student =  manager.find(Student.class, longId);
		
		manager.getTransaction().begin();
		manager.remove(student);
		manager.getTransaction().commit();
	}
}
