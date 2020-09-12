package com.tutorials.spring;

import com.tutorials.spring.config.EventConfig;
import com.tutorials.spring.events.EmployeeManager;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventsAppDemo {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        EmployeeManager employeeManager = context.getBean("employeeManager", EmployeeManager.class);
        employeeManager.createNewEmployee();

    }
}
