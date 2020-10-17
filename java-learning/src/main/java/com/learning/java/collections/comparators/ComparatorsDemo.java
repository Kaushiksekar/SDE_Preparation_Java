package com.learning.java.collections.comparators;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class EmployeeComp implements Comparable<EmployeeComp> {

    private Integer id = -1;
    private Integer age = -1;
    private String firstName = null;
    private String lastName = null;

    public EmployeeComp(Integer id, String fName, String lName, Integer age) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
    }

    //Getters and Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    @Override
    public String toString() {
        return "\nEmployee [id=" + id + ", age=" + age + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }

    @Override
    public int compareTo(EmployeeComp o) {
        return id.compareTo(o.id);
    }
}

class FirstNameSorter implements Comparator<EmployeeComp>
{
    public int compare(EmployeeComp o1, EmployeeComp o2)
    {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}

class LastNameSorter implements Comparator<EmployeeComp>
{
    public int compare(EmployeeComp o1, EmployeeComp o2)
    {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}

class AgeSorter implements Comparator<EmployeeComp>
{
    public int compare(EmployeeComp o1, EmployeeComp o2)
    {
        return o1.getAge() - o2.getAge();
    }
}

public class ComparatorsDemo {

    public static void main(String[] args) {

        List<EmployeeComp> list = Arrays.asList(new EmployeeComp(1, "A", "B", 34),
                new EmployeeComp(4, "C", "D", 30),
                new EmployeeComp(3, "B", "A", 31),
                new EmployeeComp(2, "D", "C", 25));

        Collections.sort(list, new FirstNameSorter()
                .thenComparing(new LastNameSorter())
                .thenComparing(new AgeSorter()));

        System.out.println(list);

    }

}
