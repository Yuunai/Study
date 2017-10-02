package com.krystianminta.springdemo.impls;

import com.krystianminta.springdemo.interfaces.Coach;
import com.krystianminta.springdemo.interfaces.FortuneService;

public class JuggerCoach implements Coach {

	private FortuneService fortuneService;
	
	public JuggerCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swing a sword for 300 times!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public void initMethod() {
		System.out.println("Just a littly initializer!");
	}
	
	public void destroyMethod() {
		System.out.println("Well, bye!");
	}
	
}
