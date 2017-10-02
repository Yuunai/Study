package com.krystianminta.springdemo.impls;

import com.krystianminta.springdemo.interfaces.FortuneService;

public class HappyFortuneService implements FortuneService{

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}
