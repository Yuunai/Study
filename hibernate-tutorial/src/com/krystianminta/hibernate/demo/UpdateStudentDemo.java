package com.krystianminta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krystianminta.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
	
		
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			System.out.println("Getting student with id: " + studentId);
			
			session.beginTransaction();
			
			Student student = session.get(Student.class, studentId);

			System.out.println("Get complete: " + student);
			
			student.setLastName("Dumin");
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			student = session.get(Student.class, studentId);

			System.out.println("Get complete: " + student);

			session.getTransaction().commit();
			
			
		} finally {
			factory.close();
		}
	
	
	
	}

}
