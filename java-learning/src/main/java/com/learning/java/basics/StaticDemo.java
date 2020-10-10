package com.learning.java.basics;

class Demo{
    static int a =5;
}

public class StaticDemo {

    private static int staticVar;

    public void run(){
        staticVar++;
    }

    public static void main(String[] args) {

        Demo a = new Demo();
        Demo b = new Demo();
        a.a += 1;
        System.out.println(a.a);
        System.out.println(b.a);

        System.out.println(System.getProperty("user.name"));


    }

}
