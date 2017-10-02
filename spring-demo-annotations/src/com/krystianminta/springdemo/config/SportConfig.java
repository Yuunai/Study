package com.krystianminta.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.krystianminta.springdemo.impls.SadFortuneService;
import com.krystianminta.springdemo.impls.SwimCoach;
import com.krystianminta.springdemo.interfaces.Coach;
import com.krystianminta.springdemo.interfaces.FortuneService;

@Configuration
//@ComponentScan("com.krystianminta.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	@Bean Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	
}
