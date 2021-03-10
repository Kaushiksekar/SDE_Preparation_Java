package com.learning.java.cloning;

class Employee implements Cloneable{
    String name;
    Employee(String name){
        this.name = name;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public String getName() {
        return name;
    }
    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Employee) obj).getName());
    }
}

public class CloningDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee employee1 = new Employee("Kaushik");
        Employee employee2 = (Employee) employee1.clone();
        System.out.println(employee1==employee2);
        System.out.println(employee1.equals(employee2));
    }
}
