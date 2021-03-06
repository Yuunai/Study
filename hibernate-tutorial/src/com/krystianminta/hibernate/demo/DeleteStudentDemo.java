package com.krystianminta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krystianminta.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			//Already deleted!
			//session.delete(student);
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();

			
		} finally {
			factory.close();
		}
	
	
	
	}

}
