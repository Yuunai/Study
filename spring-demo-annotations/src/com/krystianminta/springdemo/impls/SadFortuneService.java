package com.krystianminta.springdemo.impls;

import com.krystianminta.springdemo.interfaces.FortuneService;

public class SadFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "Today is a sad day! :c";
	}

}
