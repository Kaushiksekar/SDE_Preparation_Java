package com.learning.java.design_patterns.singleton;

class EagerSingleton{

    private static volatile EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton(){ }

    public static EagerSingleton getInstance(){
        return eagerSingleton;
    }

    void print(){
        System.out.println("Inside print");
    }

}

public class EagerSingletonDemo {

    public static void main(String[] args) {
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        eagerSingleton.print();
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        System.out.println(eagerSingleton==eagerSingleton1);
    }
}
