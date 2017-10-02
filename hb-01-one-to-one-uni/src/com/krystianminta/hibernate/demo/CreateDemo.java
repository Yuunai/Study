package com.krystianminta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krystianminta.hibernate.demo.entity.Instructor;
import com.krystianminta.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
	
		
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor instructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
			
			InstructorDetail detail = new InstructorDetail(
					"http://youtube.com", "Guitar!");
			
			instructor.setInstructorDetail(detail);
			
			session.beginTransaction();
			
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	
	
	
	}

}
