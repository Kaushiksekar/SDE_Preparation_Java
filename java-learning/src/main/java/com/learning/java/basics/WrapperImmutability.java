package com.learning.java.basics;

public class WrapperImmutability {

    static int i=5;

    public static void main(String[] args) {

        Integer a = 10;
        System.out.println(System.identityHashCode(a));
        a = a + 1;
        System.out.println(System.identityHashCode(a));

        new A().run();
        new B().run();

    }
}

class A{

    void run(){
        WrapperImmutability.i += 1;
        System.out.println(WrapperImmutability.i);
    }

}

class B{

    void run(){
        System.out.println(WrapperImmutability.i);
    }

}
