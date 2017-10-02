package com.krystianminta.springdemo.impls;

import com.krystianminta.springdemo.interfaces.Coach;
import com.krystianminta.springdemo.interfaces.FortuneService;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public void startupStuff() {
		System.out.println("TrackCoach: Building a spaceship!");
	}
	
	public void deathWish() {
		System.out.println("TrackCoach: Death sentence!");
	}
	
}
