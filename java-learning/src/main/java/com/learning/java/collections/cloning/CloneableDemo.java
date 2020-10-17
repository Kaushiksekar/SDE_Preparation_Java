package com.learning.java.collections.cloning;

class Employee implements Cloneable{

    int id;
    String name;
    Department department;

    public Employee(int id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Department{

    String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}

public class CloneableDemo {

    public static void main(String[] args) throws CloneNotSupportedException {

        Department d = new Department("Automative");
        Employee e = new Employee(1, "Kaushik", d);

        Employee e1 = (Employee) e.clone();
        System.out.println(e == e1); // memory address is different

        // but although e1 is different, changing d would affect e1 as well as it is not deep cloned

        d.setDepartmentName("SDE");
        System.out.println(e.getDepartment().getDepartmentName());
        System.out.println(e1.getDepartment().getDepartmentName());

    }
}
