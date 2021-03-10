package com.learning.java.basics;

interface ExampleA{
    default void hello(){
        System.out.println("Hello from Example A");
    }
}

interface ExampleB{
    default void hello(){
        System.out.println("Hello from Example B");
    }
}

public class MultiInhertanceDemo implements ExampleA, ExampleB {

    @Override
    public void hello() {
        ExampleA.super.hello();
        ExampleB.super.hello();
    }

    public static void main(String[] args) {
        new MultiInhertanceDemo().hello();
    }
}
