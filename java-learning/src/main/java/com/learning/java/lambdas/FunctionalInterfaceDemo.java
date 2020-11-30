package com.learning.java.lambdas;

@FunctionalInterface
interface FunctionalInterfaceExample{
    void hello();
}

public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        FunctionalInterfaceExample functionalInterfaceExample = () -> {
            System.out.println("Inside hello");
        };

        functionalInterfaceExample.hello();
    }
}
