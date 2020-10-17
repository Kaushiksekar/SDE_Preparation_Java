package com.learning.java.collections.comparables;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee>{

    String name;
    Integer age;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Employee o) {
        return this.age.compareTo(o.age);
    }
}

public class ComparableDemo {

    public static void main(String[] args) {

        Employee e = new Employee("Kaushik", 27);
        Employee e1 = new Employee("Sony", 26);
        Employee e2 = new Employee("Akshaya", 25);

        Employee[] employeesArray = new Employee[3];
        employeesArray[0] = e;
        employeesArray[1] = e1;
        employeesArray[2] = e2;

        Arrays.sort(employeesArray);

        for(Employee item : employeesArray){
            System.out.println(item.name);
            System.out.println(item.age);
        }

    }

}
