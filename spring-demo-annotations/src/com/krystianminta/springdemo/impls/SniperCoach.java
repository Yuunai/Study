package com.krystianminta.springdemo.impls;

import com.krystianminta.springdemo.interfaces.Coach;
import com.krystianminta.springdemo.interfaces.FortuneService;

public class SniperCoach implements Coach {

	private FortuneService fortuneService;
	
	public SniperCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Shot 100 chickens today!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

}
