package com.learning.java.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Employee{
    String name;
    int age;
    String sex;

    public Employee(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}

public class PredicateDemo {

    public static Predicate<Employee> isAdultMale(){
        return employee -> employee.age > 21 && employee.sex.equals("M");
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>() {{
            add(new Employee("Kaushik", 27, "M"));
            add(new Employee("Sony", 27, "F"));
        }};
        employees.stream().filter(isAdultMale()).forEach(System.out::println);
    }
}
