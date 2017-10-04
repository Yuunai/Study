package com.krystianminta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krystianminta.hibernate.demo.entity.Course;
import com.krystianminta.hibernate.demo.entity.Instructor;
import com.krystianminta.hibernate.demo.entity.InstructorDetail;
import com.krystianminta.hibernate.demo.entity.Review;
import com.krystianminta.hibernate.demo.entity.Student;

public class DeleteMaryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
	
		
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Student mary = session.get(Student.class, 2);

			session.delete(mary);

			session.getTransaction().commit();
			
		} finally {
			
			session.close();
			
			factory.close();
		}
	
	
	
	}

}
