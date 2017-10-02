package com.krystianminta.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.krystianminta.springdemo.impls.AmazingFortuneService;
import com.krystianminta.springdemo.impls.SniperCoach;
import com.krystianminta.springdemo.interfaces.Coach;
import com.krystianminta.springdemo.interfaces.FortuneService;

@Configuration
public class ActivityConfig {

	@Bean
	public FortuneService amazingFortuneService() {
		return new AmazingFortuneService();
	}
	
	@Bean
	public Coach sniperCoach() {
		return new SniperCoach(amazingFortuneService());
	}
}
