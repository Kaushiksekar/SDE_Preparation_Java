package com.learning.java.basics;

class EmployeeDefault{
    private String name;
    private Integer age;

    public EmployeeDefault(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

class EmployeeStd{
    private String name;
    private Integer age;

    public EmployeeStd(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((EmployeeStd) obj).name) && this.age.equals(((EmployeeStd) obj).age);
    }

    @Override
    public int hashCode()
    {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + age;
        return result;
    }
}

public class EqualsHashcodeDemo1 {

    public static void main(String[] args) {
        EmployeeDefault employeeDefault = new EmployeeDefault("Kaushik", 27);
        EmployeeDefault employeeDefault1 = new EmployeeDefault("Kaushik", 27);
        // by default when equals method is not there, equality checks if its in the same memory address
        System.out.println(employeeDefault.equals(employeeDefault1));

        EmployeeStd employeeStd = new EmployeeStd("Kaushik", 27);
        EmployeeStd employeeStd1 = new EmployeeStd("Kaushik", 27);
        System.out.println(employeeStd.equals(employeeStd1));
        employeeStd = new EmployeeStd("Sony", 27);
        System.out.println(employeeStd.equals(employeeStd1));
    }
}
