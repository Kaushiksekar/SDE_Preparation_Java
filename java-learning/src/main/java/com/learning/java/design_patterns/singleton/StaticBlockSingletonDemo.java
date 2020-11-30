package com.learning.java.design_patterns.singleton;

class StaticBlockSingleton{

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton() { }

    static {
        instance = new StaticBlockSingleton();
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}

public class StaticBlockSingletonDemo {

    public static void main(String[] args) {
        System.out.println(StaticBlockSingleton.getInstance()==StaticBlockSingleton.getInstance());
    }
}
