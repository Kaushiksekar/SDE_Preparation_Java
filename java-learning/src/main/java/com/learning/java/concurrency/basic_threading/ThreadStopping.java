package com.learning.java.concurrency.basic_threading;

public class ThreadStopping {

    public static void main(String[] args) {
        MyRunnable runnable1 = new MyRunnable();
        Thread t1 = new Thread(runnable1, "Thread 1");
        t1.start();
        runnable1.doStop();

    }
}

class MyRunnable implements Runnable {

    private boolean doStop = false;

    public synchronized void doStop() {
        System.out.println("Do stop called from : " + Thread.currentThread().getName());
        this.doStop = true;
    }

    private synchronized boolean keepRunning() {
        System.out.println("keepRunning called from : " + Thread.currentThread().getName());
        return this.doStop == false;
    }

    @Override
    public void run() {
        while(keepRunning()) {
            // keep doing what this thread should do.
            System.out.println("Running");

            try {
                Thread.sleep(3L * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}