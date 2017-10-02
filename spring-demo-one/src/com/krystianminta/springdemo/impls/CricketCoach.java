package com.krystianminta.springdemo.impls;

import com.krystianminta.springdemo.interfaces.Coach;
import com.krystianminta.springdemo.interfaces.FortuneService;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	private String emailAdress;
	private String team;
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}



	public CricketCoach() {
		
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
