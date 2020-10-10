package com.learning.java.concurrency.basic_threading;

public class RudimentaryThreading {

    public static void main(String[] args) {

        System.out.println("Name of the thread: " + Thread.currentThread().getName());

        for (int i=0; i<10; i++){
            new Thread("" + i){
                @Override
                public void run() {
                    System.out.println("Name of the thread: " + Thread.currentThread().getName());
                }
            }.start();
        }

    }

}
