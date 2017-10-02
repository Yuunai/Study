package com.krystianminta.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.krystianminta.springdemo.config.SportConfig;
import com.krystianminta.springdemo.impls.SwimCoach;
import com.krystianminta.springdemo.interfaces.Coach;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
		
		System.out.println(coach.getDailyWorkout());
		
		System.out.println(coach.getDailyFortune());
		
		System.out.println("Email: " + coach.getEmail());
		
		System.out.println("Team: " + coach.getTeam());
		
		context.close();

	}

}
