package com.learning.java.design_patterns.singleton;

class LazySingleton{

    private static volatile LazySingleton lazySingleton = null;

    private LazySingleton(){ }

    public static LazySingleton getInstance(){
        if (lazySingleton == null){
            synchronized (LazySingleton.class){
                if (lazySingleton == null){ // double checking because another thread might already be waiting
                    // after executing synchronized step in which case 2nd object will be created.
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    public void print(){
        System.out.println("Inside print");
    }

}

public class LazySingletonDemo {

    public static void main(String[] args) {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        lazySingleton.print();
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        System.out.println(lazySingleton==lazySingleton1);
    }

}
