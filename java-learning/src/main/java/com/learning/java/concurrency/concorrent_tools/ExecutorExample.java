package com.learning.java.concurrency.concorrent_tools;

import java.util.concurrent.Executor;

public class ExecutorExample {

    public static void main(String[] args) {

        Executor executor = new Invoker();
        executor.execute(() -> {
            for (int i=0; i<10; i++){
                System.out.println(i);
            }
        });

        ((Executor) command -> command.run()).execute(() -> {
            for (int i=0; i<10; i++){
                System.out.println(i);
            }
        });

    }

}

class Invoker implements Executor{

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}