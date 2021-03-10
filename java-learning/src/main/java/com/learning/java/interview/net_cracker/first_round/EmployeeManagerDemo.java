package com.learning.java.interview.net_cracker.first_round;

import java.util.*;

class Employee{
    int id;
    String name;
    int managerId;

    public Employee(int id, String name, int managerId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
    }
    public int getManagerId() {
        return managerId;
    }
}

public class EmployeeManagerDemo {

    static Map<Integer, List<Employee>> groupByManager(Employee[] employees){
        Map<Integer, List<Employee>> map = new HashMap<>();
        for (Employee employee: employees){
            if (map.containsKey(employee.managerId)){
                map.get(employee.managerId).add(employee);
            }
            else{
                map.put(employee.managerId, new ArrayList<>() {{add(employee);}});
            }
        }
        return map;

//        Comparator.comparing(Employee::getManagerId);

    }

    public static void main(String[] args) {

        Employee employee1 = new Employee(1, "A", 5);
        Employee employee2 = new Employee(2, "B", 5);
        Employee employee3 = new Employee(3, "C", 6);
        Employee employee4 = new Employee(4, "D", 6);
        Employee employees [] = new Employee[4];
        employees[0] = employee1;
        employees[1] = employee2;
        employees[2] = employee3;
        employees[3] = employee4;

        Map<Integer, List<Employee>> groupedByManager = EmployeeManagerDemo.groupByManager(employees);
        groupedByManager.forEach((integer, employeesList) -> {
            System.out.println("Manager ID : " + integer);
            for (Employee employee : employeesList)
                System.out.println("Employee name " + employee.name);
        });

    }
}
