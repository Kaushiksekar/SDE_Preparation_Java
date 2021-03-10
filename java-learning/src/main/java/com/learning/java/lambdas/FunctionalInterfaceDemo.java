package com.learning.java.lambdas;

@FunctionalInterface
interface FunctionalInterfaceExample{

    static void run(){
        System.out.println("run");
    }
    void hello();

    default void move(){
        System.out.println("move");
    }
}

public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        FunctionalInterfaceExample functionalInterfaceExample = () -> {
            System.out.println("Inside hello");
        };

        functionalInterfaceExample.move();
        FunctionalInterfaceExample.run();

        functionalInterfaceExample.hello();
    }
}
