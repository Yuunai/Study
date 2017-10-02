package com.krystianminta.springdemo.impls;

import java.util.Random;

import com.krystianminta.springdemo.interfaces.FortuneService;

public class RandomFortuneService implements FortuneService {

	private Random random = new Random();
	
	private String fortunes[] = {
			"Today is your lucky day!",
			"Today is just a normal day.",
			"Today is a bad day!"
	};
	
	@Override
	public String getFortune() {
		return fortunes[java.lang.Math.abs(random.nextInt())%3];
	}

}
