package com.krystianminta.springdemo.impls;

import org.springframework.stereotype.Component;

import com.krystianminta.springdemo.interfaces.FortuneService;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "Today is your (un)lucky day!";
	}

}
