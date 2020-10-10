package com.learning.java.concurrency.basic_threading;

public class ThreadLocalsExample {

    public static void main(String[] args) {
        MyRunnable1 sharedInstance = new MyRunnable1();
        new Thread(sharedInstance, "Thread1").start();
        new Thread(sharedInstance, "Thread2").start();
    }

}

class MyRunnable1 implements  Runnable{

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    @Override
    public void run() {
        threadLocal.set((int) (Math.random() * 100D));
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread : " + Thread.currentThread().getName() + " : " + threadLocal.get());
    }
}