package com.tutorials.spring.annotation_domain;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SchedulerDemo {

    @Scheduled(fixedDelay = 5000)
    public void scheduledDemo(){
        System.out.println("Executing every 5 seconds. Current time is : " + new Date());
    }

}
