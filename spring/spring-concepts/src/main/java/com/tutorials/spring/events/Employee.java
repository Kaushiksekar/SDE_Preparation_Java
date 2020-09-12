package com.tutorials.spring.events;

public class Employee
{
    private Integer id;
    private String firstName;
    private String lastName;
    private String designation;

    public Employee(String designation)
    {
        this.id = -1;
        this.firstName = "dummy";
        this.lastName = "dummy";
        this.designation = designation;
    }

    public Employee() {
        // TODO Auto-generated constructor stub
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", type=" + designation + "]";
    }
}