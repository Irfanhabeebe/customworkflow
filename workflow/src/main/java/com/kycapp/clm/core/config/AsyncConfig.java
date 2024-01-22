package com.kycapp.clm.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean("customTaskExecutor")
    public TaskExecutor customTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10); // Set the core pool size as needed
        executor.setMaxPoolSize(20); // Set the maximum pool size as needed
        executor.setQueueCapacity(500); // Set the queue capacity as needed
        executor.setThreadNamePrefix("customTaskExecutor-");
        executor.initialize();
        return executor;
    }
}
