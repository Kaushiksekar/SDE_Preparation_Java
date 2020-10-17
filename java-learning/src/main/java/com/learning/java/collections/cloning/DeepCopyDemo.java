package com.learning.java.collections.cloning;

class Employee1 implements Cloneable{

    int id;
    String name;
    Department1 department;

    public Employee1(int id, String name, Department1 department) {
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

    public Department1 getDepartment() {
        return department;
    }

    public void setDepartment(Department1 department) {
        this.department = department;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee1 cloned = (Employee1) super.clone();
        cloned.setDepartment((Department1) cloned.getDepartment().clone());
        return cloned;
    }
}

class Department1 implements Cloneable{

    String departmentName;

    public Department1(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class DeepCopyDemo {

    public static void main(String[] args) throws CloneNotSupportedException {

        Department1 d = new Department1("Automative");
        Employee1 e = new Employee1(1, "Kaushik", d);

        Employee1 e1 = (Employee1) e.clone();
        System.out.println(e == e1);

        d.setDepartmentName("SDE");
        System.out.println(e.getDepartment().getDepartmentName());
        System.out.println(e1.getDepartment().getDepartmentName());

        // departments would be different as this is a deep copy and not shallow copy


    }

}
