package com.eric.notes.threadfactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import java.util.concurrent.*;
/**
 * <p>
 * 线程池
 * </p>
 *
 * @author Eric Jin
 */
@Configuration
@EnableAsync
public class AsyncExecutorConfig {

    @Bean("registerExecutor")
    public Executor caseStartFinishExecutor() {

        ThreadFactory nameThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("registerExecutor-%d").build();

        return new ThreadPoolExecutor(100, 200, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), nameThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    }
}

