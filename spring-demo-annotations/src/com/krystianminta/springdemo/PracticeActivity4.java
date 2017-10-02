package com.krystianminta.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.krystianminta.springdemo.interfaces.Coach;

public class PracticeActivity4 {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("magesCoach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
			
		context.close();

	}

}
