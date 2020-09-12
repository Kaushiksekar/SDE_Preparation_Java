package com.tutorials.spring.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service("employeeManager")
public class EmployeeManagerImpl implements EmployeeManager, ApplicationEventPublisherAware {

    @Autowired
    private EmployeeDAO employeeDAO;

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public Employee createNewEmployee() {
        Employee employee = employeeDAO.createNewEmployee();
        publisher.publishEvent(new EmployeeEvent(this, "ADD", employee));
        return employee;
    }
}
