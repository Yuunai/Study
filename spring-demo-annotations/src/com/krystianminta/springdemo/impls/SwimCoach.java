package com.krystianminta.springdemo.impls;

import org.springframework.beans.factory.annotation.Value;

import com.krystianminta.springdemo.interfaces.Coach;
import com.krystianminta.springdemo.interfaces.FortuneService;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${swimCoach.email}")
	private String email;
	
	@Value("${swimCoach.team}")
	private String team;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warm up.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	
	
}
