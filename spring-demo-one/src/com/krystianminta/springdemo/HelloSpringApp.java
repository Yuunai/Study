package com.krystianminta.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.krystianminta.springdemo.impls.CricketCoach;
import com.krystianminta.springdemo.interfaces.Coach;

public class HelloSpringApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach coach = context.getBean("myCoach", Coach.class);
		CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);		
		//call methods on the bean
		
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());
		
		System.out.println(cricketCoach.getEmailAdress());
		System.out.println(cricketCoach.getTeam());
		//close the context
		context.close();
	}

}
