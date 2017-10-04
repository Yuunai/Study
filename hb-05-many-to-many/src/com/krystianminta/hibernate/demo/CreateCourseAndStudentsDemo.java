package com.krystianminta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krystianminta.hibernate.demo.entity.Course;
import com.krystianminta.hibernate.demo.entity.Instructor;
import com.krystianminta.hibernate.demo.entity.InstructorDetail;
import com.krystianminta.hibernate.demo.entity.Review;
import com.krystianminta.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			Course course = new Course("Pacman - How To Score One Million Points");
			
			session.save(course);
			
			Student s1 = new Student("Krystian", "Minta", "minta96@gmail.com");
			Student s2 = new Student("Marry", "Deo", "madeo@gmail.com");
			
			course.addStudent(s1);
			course.addStudent(s2);
			
			session.save(s1);
			session.save(s2);
			
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
			
			factory.close();
		}
	
	
	
	}

}
