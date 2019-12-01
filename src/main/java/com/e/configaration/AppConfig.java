package com.e.configaration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@Import(TaskPoolConfig.class)
public class AppConfig {

	private static final Logger log = LoggerFactory.getLogger(AppConfig.class);

	
	
}
