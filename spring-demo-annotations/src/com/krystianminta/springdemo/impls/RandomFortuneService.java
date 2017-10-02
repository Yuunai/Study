package com.krystianminta.springdemo.impls;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.krystianminta.springdemo.interfaces.FortuneService;

@Component
public class RandomFortuneService implements FortuneService {

	private Random random = new Random();
	
	private String fortunes[] = {
			"Today is your lucky day!",
			"Adventure time!",
			"Let's conquer the world!"
	};
	
	@Override
	public String getDailyFortune() {
		return fortunes[java.lang.Math.abs(random.nextInt())%3];
	}

}
