package com.learning.java.serialization;

import java.io.*;

public class Demo1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        POJO pojo = new POJO(1, "A", "B", 2);
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("pojo.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(pojo);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        POJO pojo1;
        System.out.println(POJO.c);
        POJO.c = 5;
        try{
            FileInputStream fileIn = new FileInputStream("pojo.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileIn);
            pojo1 = (POJO) objectInputStream.readObject();
            objectInputStream.close();
            fileIn.close();

            System.out.println(pojo1.a);
            System.out.println(pojo1.b);
            System.out.println(POJO.c); // prints 5 which means static variables are not serialized
            // but final and static fields will have data as they are part of the class
            // only serialVersionUID static variables are serialized because they are special
            System.out.println(pojo1.d);

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
