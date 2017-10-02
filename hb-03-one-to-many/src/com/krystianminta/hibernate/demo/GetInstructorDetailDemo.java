package com.krystianminta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krystianminta.hibernate.demo.entity.Instructor;
import com.krystianminta.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int id = 2;
			
			InstructorDetail detail = session.get(InstructorDetail.class, id);
			
			System.out.println("Instructor detail: " + detail);
			
			System.out.println("Connectoed instructor: " + detail.getInstructor());
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
