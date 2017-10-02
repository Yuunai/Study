package com.krystianminta.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.krystianminta.springdemo.interfaces.Coach;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("fieldCoach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		
		context.close();

	}

}
