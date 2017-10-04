package com.krystianminta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krystianminta.hibernate.demo.entity.Course;
import com.krystianminta.hibernate.demo.entity.Instructor;
import com.krystianminta.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
	
		
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Course course = new Course("How to guitar solo!");
			
			Course course1 = new Course("Coding with music!");
			
			session.beginTransaction();
			
			int id = 2;
			
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("Adding course: " + course);
			instructor.add(course);
			
			System.out.println("Adding course: " + course1);
			instructor.add(course1);
			
			System.out.println("Saving instructor: " + instructor);
			
			session.save(course);
			session.save(course1);
			
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
			
			factory.close();
		}
	
	
	
	}

}
