package com.tutorials.spring;

import com.tutorials.spring.config.EventsSimplifiedConfig;
import com.tutorials.spring.events_simplified.StringEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventsSimplifiedAppDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(EventsSimplifiedConfig.class);
        StringEventPublisher stringEvent = context.getBean("stringEventPublisher", StringEventPublisher.class);
        stringEvent.publish();
    }

}
