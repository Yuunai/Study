package com.krystianminta.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.krystianminta.springdemo.interfaces.Coach;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach.getDailyFortune());
		System.out.println("Tu ru ru tu ru!");
		
		context.close();
	}

}
