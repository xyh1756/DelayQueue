package com.messagequeue.delayqueue.listener;

import com.messagequeue.delayqueue.core.DelayBucketHandler;
import com.messagequeue.delayqueue.core.DelayQueue;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ExecutorService executorService = Executors.newFixedThreadPool((int) DelayQueue.DELAY_BUCKET_NUM);
        for (int i = 0; i < DelayQueue.DELAY_BUCKET_NUM; i++) {
            executorService.execute(new DelayBucketHandler(DelayQueue.DELAY_BUCKET_KEY_PREFIX+i));
        }
    }
}
