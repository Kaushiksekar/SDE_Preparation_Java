package com.learning.java.basics;

import java.io.*;

class Employee1 implements Serializable{

    public String firstName;
    public String lastName;
    public transient String confidentialInfo;

}

public class SerializableDemoWithTransient {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("employee.ser"));
        Employee1 employee = new Employee1();
        employee.firstName = "Kaushik";
        employee.lastName = "Sekar";
        employee.confidentialInfo = "asfdasdfas";
        objectOutputStream.writeObject(employee);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("employee.ser"));
        Employee1 employee1 = (Employee1) objectInputStream.readObject();
        System.out.println(employee1.firstName);
        System.out.println(employee1.lastName);
        System.out.println(employee1.confidentialInfo);
    }
}
