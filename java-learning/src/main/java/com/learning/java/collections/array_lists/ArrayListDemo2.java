package com.learning.java.collections.array_lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
    String name;
    int age;
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ArrayListDemo2 {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(new Employee("Sony", 27),
                new Employee("Kaushik", 27));
        employees.sort((o1, o2) -> o1.name.compareTo(o2.name));
        System.out.println(employees);

        employees.sort(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName));

        // same thing with streams
        List<Employee> newList = employees.stream().sorted(Comparator.comparing(Employee::getAge)
                .thenComparing(Employee::getName))
                .collect(Collectors.toList());
        System.out.println(newList);
    }
}
