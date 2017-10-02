package com.krystianminta.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.krystianminta.springdemo.interfaces.Coach;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach alphaCoach = context.getBean("magesCoach", Coach.class);
		Coach betaCoach = context.getBean("magesCoach", Coach.class);
		
		System.out.println("Same coach: " + (alphaCoach == betaCoach));
		
		System.out.println("alphaCoach: " + alphaCoach);
		System.out.println("betaCoach: " + betaCoach);		
		
		context.close();
	}

}
