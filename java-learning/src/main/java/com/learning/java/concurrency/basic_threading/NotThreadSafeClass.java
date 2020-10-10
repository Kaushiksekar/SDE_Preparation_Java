package com.learning.java.concurrency.basic_threading;

public class NotThreadSafeClass implements Runnable {

    NotThreadSafeRunnable instance = null;

    public NotThreadSafeClass(NotThreadSafeRunnable instance) {
        this.instance = instance;
    }

    public static void main(String[] args) {

        //Non thread safe example
        NotThreadSafeRunnable sharedInstance = new NotThreadSafeRunnable();
        new Thread(new NotThreadSafeClass(sharedInstance), "Thread 1").start();
        new Thread(new NotThreadSafeClass(sharedInstance), "Thread 2").start();
        // both threads add to the same stringbuilder object which is not thread safe
        // this only happens when threads share the same instance
        // if threads have their own instance, it will be thread safe

        //Thread Safe example
        new Thread(new NotThreadSafeClass(new NotThreadSafeRunnable()), "Thread 3").start();
        new Thread(new NotThreadSafeClass(new NotThreadSafeRunnable()), "Thread 4").start();
    }

    @Override
    public void run() {
        instance.add("some text ");
        System.out.println("From : " + Thread.currentThread().getName() +" and value is " +
                instance.stringBuilder.toString());
    }
}

class NotThreadSafeRunnable{

    StringBuilder stringBuilder = new StringBuilder();

    public void add(String text) {
        this.stringBuilder.append(text);
    }
}
