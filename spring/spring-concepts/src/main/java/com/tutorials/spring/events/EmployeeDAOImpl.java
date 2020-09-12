package com.tutorials.spring.events;

import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public Employee createNewEmployee() {
        Employee e = new Employee();
        e.setId(1);
        e.setFirstName("Kaushik");
        e.setLastName("S");
        return e;
    }
}
