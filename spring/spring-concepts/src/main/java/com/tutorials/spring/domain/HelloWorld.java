package com.tutorials.spring.domain;

public class HelloWorld {

    public HelloWorld() {
    }

    public void printHello(){
        System.out.println("Hello World");
    }

    public void customInitMethod(){
        System.out.println("Inside Hello World's custom init method");
    }

    public void customDestroyMethod(){
        System.out.println("Inside Hello World's custom destroy method");
    }
}
