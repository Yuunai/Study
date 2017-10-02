package com.krystianminta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krystianminta.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
	
		
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Student student = new Student("Krystian", "Minta", "minta96@gmail.com");
			
			session.beginTransaction();
			
			
			System.out.println("Saving the student...");
			System.out.println(student);
			session.save(student);
			
			session.getTransaction().commit();
			System.out.println("Student saved! Id: " + student.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGetting student with id: " + student.getId());
			
			Student theStudent = session.get(Student.class, student.getId());
			
			System.out.println("Get complete" + theStudent);
			
			session.getTransaction().commit();
			
			
			
			
			
		} finally {
			factory.close();
		}
	
	
	
	}

}
