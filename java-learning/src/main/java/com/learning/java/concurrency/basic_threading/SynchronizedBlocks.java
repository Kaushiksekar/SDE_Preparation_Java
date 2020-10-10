package com.learning.java.concurrency.basic_threading;

class MathClass{

    void printNumbers(int n) throws InterruptedException {
        synchronized (this){
            for (int i=0; i<n; i++){
                System.out.println(Thread.currentThread().getName()+ "::" + i);
                // this sleep is within the thread, so the current thread still holds the lock
                // referenced at the start of the synchronized block
                Thread.sleep(500);
            }
        }
    }

}

public class SynchronizedBlocks {

    public static void main(String[] args) throws InterruptedException {

        final MathClass mathClass = new MathClass();

        Runnable r = () -> {
            try {
                mathClass.printNumbers(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(r, "ONE").start();
        new Thread(r, "TWO").start();

    }
}
