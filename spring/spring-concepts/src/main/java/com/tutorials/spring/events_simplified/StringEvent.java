package com.tutorials.spring.events_simplified;

import org.springframework.context.ApplicationEvent;

public class StringEvent extends ApplicationEvent {

    private String eventName;

    public StringEvent(Object source, String eventName) {
        super(source);
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }
}
