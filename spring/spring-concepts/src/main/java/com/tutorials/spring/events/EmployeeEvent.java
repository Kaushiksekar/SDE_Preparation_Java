package com.tutorials.spring.events;

import org.springframework.context.ApplicationEvent;

public class EmployeeEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private String eventType;
    private Employee employee;

    public EmployeeEvent(Object source, String eventType, Employee employee) {
        super(source);
        this.employee = employee;
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }

    public Employee getEmployee() {
        return employee;
    }
}
