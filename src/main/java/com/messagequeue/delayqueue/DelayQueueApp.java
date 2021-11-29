package com.messagequeue.delayqueue;

import com.messagequeue.delayqueue.listener.ApplicationStartup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DelayQueueApp {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DelayQueueApp.class);
        application.addListeners(new ApplicationStartup());
        application.run(args);
    }
}
