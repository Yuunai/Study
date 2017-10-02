package com.krystianminta.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.krystianminta.springdemo.interfaces.Coach;

public class PracticeActivity3 {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("practiceActivity-applicationContext.xml");
		
		Coach first = context.getBean("myCoach", Coach.class);
		Coach second = context.getBean("myCoach", Coach.class);
		
		if(first.equals(second)) {
			System.out.println("Same coaches here!");
		} else {
			System.out.println("Different ones!");
		}
		
		System.out.println(first);
		System.out.println(second);
		
		
		context.close();
	}

}
