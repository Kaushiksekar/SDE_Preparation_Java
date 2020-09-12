package com.tutorials.spring.events_simplified;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StringEventListener implements ApplicationListener<StringEvent> {

    @Override
    public void onApplicationEvent(StringEvent stringEvent) {
        System.out.println(stringEvent.getEventName());
        System.out.println(stringEvent.getTimestamp());
    }
}
