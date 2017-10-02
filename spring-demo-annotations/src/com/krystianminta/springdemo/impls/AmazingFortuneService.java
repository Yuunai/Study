package com.krystianminta.springdemo.impls;

import com.krystianminta.springdemo.interfaces.FortuneService;

public class AmazingFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "You are amazing!";
	}

}
