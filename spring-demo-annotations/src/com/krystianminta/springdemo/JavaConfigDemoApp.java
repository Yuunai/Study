package com.krystianminta.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.krystianminta.springdemo.config.SportConfig;
import com.krystianminta.springdemo.interfaces.Coach;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		Coach coach = context.getBean("fieldCoach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		
		System.out.println(coach.getDailyFortune());
		
		context.close();

	}

}
