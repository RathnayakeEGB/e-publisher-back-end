package com.e;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.e.configaration.AppConfig;
import com.e.configaration.TaskPoolConfig;
import com.e.configaration.security.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class E_publisher_Application {

	private static final Logger log = LoggerFactory.getLogger(E_publisher_Application.class);

	
	public static void main(String[] args) {
		SpringApplication.run(E_publisher_Application.class, args);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		log.debug("[_______________Application Running............. ");
	}

}
