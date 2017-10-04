package com.krystianminta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krystianminta.hibernate.demo.entity.Course;
import com.krystianminta.hibernate.demo.entity.Instructor;
import com.krystianminta.hibernate.demo.entity.InstructorDetail;
import com.krystianminta.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
	
		
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Course course = new Course("Pacman - How To Score One Million Points");
			
			course.addReview(new Review("Gread course...Loved it!"));
			course.addReview(new Review("Cool course, job well done!"));
			course.addReview(new Review("Dumb ocurse, you are an idiot!"));
			
			session.save(course);
			
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
			
			factory.close();
		}
	
	
	
	}

}
