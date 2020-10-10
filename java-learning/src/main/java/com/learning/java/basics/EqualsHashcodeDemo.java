package com.learning.java.basics;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.*;

@Getter
@Setter
class Employee{

    private Integer id;
    private String firstname;
    private String lastName;
    private String department;

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (obj == this){
            return true;
        }
        if (obj.getClass() != this.getClass()){
            return false;
        }
        Employee e = (Employee) obj;
        return (e.getId() == getId());
    }

    @Override
    public int hashCode(){
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + getId();
        return result;
    }
}

public class EqualsHashcodeDemo {

    public static void main(String[] args) {

        Employee e1 = new Employee();
        Employee e2 = new Employee();

        e1.setId(100);
        e2.setId(100);

        System.out.println(e1.equals(e2)); // returns false if equals is not overrided
        // returns true is equals is properly overrided

        Set<Employee> employees = new HashSet<>(); // hash set will remove duplicate objects
        employees.add(e1);
        employees.add(e2);
        System.out.println(employees); // prints two different hashcodes when hashcode is not overrided
        // prints one hashcode if two objects are same and hashcode is overrided properly
        // only prints one hashcode because it is a set and does not contain duplicate objects

    }

}
