package com.krystianminta.springdemo.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.krystianminta.springdemo.interfaces.Coach;
import com.krystianminta.springdemo.interfaces.FortuneService;

@Component
public class HuntersCoach implements Coach {

	private FortuneService fortuneService;
	
	public HuntersCoach() {
		
	}
	
	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Go hunting and bring me 10 boars!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

}
