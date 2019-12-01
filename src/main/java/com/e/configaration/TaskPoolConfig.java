package com.e.configaration;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class TaskPoolConfig implements AsyncConfigurer {
	
	private static final Logger log = LoggerFactory.getLogger(TaskPoolConfig.class);

	
	public TaskPoolConfig() {
		log.debug("[----------------------------------TaskPoolConfig---------------------]");
	}

	private static final int MAX_POOL_SIZE=30;
	private static final int CORE_POOL_SIZE=30;
	private static final int QUEUE_CAPACITY=30;

	@Override
	public Executor getAsyncExecutor() {

		ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
		pool.setMaxPoolSize(MAX_POOL_SIZE);
		pool.setCorePoolSize(CORE_POOL_SIZE);
		pool.setQueueCapacity(QUEUE_CAPACITY);
		pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		pool.setThreadNamePrefix("e-publisher....");
		
		return pool;
	}

}
