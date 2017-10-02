package com.krystianminta.springdemo.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.krystianminta.springdemo.interfaces.Coach;
import com.krystianminta.springdemo.interfaces.FortuneService;

@Component
public class WarriorsCoach implements Coach {

	private FortuneService fortuneService;
	
	@Autowired
	public WarriorsCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swing your sword 500 times!";
	}
	
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

}
