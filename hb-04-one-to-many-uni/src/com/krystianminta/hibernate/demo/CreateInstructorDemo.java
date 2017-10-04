package com.krystianminta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krystianminta.hibernate.demo.entity.Course;
import com.krystianminta.hibernate.demo.entity.Instructor;
import com.krystianminta.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
	
		
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor instructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
			
			InstructorDetail detail = new InstructorDetail(
					"http://youtube.com", "Guitar!");
			
			Course course = new Course("How to guitar solo!");
			
			Course course1 = new Course("Coding with music!");
			
			instructor.setInstructorDetail(detail);
			
			System.out.println("Adding course: " + course);
			instructor.add(course);
			
			System.out.println("Adding course: " + course1);
			instructor.add(course1);
			
			session.beginTransaction();
			
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);
			
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
			
			factory.close();
		}
	
	
	
	}

}
