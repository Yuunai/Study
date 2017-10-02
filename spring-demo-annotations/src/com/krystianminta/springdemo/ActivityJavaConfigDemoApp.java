package com.krystianminta.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.krystianminta.springdemo.config.ActivityConfig;
import com.krystianminta.springdemo.interfaces.Coach;

public class ActivityJavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ActivityConfig.class);
		
		Coach coach = context.getBean("sniperCoach", Coach.class);
		
		System.out.println(coach.getDailyFortune());
		
		System.out.println(coach.getDailyWorkout());
		
		context.close();

	}

}
