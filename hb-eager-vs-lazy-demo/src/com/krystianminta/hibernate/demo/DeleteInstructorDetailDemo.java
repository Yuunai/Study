package com.krystianminta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krystianminta.hibernate.demo.entity.Instructor;
import com.krystianminta.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int id = 3;
			
			InstructorDetail detail = session.get(InstructorDetail.class, id);
			
			System.out.println("Instructor detail: " + detail);
			
			System.out.println("Connected instructor: " + detail.getInstructor());
			
			System.out.println("Deleting instructor detail: " + detail);
			
			detail.getInstructor().setInstructorDetail(null);
			
			session.delete(detail);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
