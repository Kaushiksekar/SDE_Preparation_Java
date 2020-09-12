package com.tutorials.spring.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventsProcessor implements ApplicationListener<EmployeeEvent> {
    @Override
    public void onApplicationEvent(EmployeeEvent employeeEvent) {
        System.out.println("Event Type : " + employeeEvent.getEventType() + " & employee : " + employeeEvent.getEmployee().getFirstName());
    }
}
