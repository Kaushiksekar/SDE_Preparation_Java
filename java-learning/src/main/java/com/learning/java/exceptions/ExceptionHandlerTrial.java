package com.learning.java.exceptions;

import java.util.Date;

import static java.lang.Thread.UncaughtExceptionHandler;

class A implements UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Inside exception handler");
    }
}

public class ExceptionHandlerTrial {

    public static void main(String[] args) {

        Thread.currentThread().setUncaughtExceptionHandler((t, e) ->
                System.out.println("Inside exception handler")); // using this instead of using instance of
        // above class

        Date date = null;
        date.hashCode();

        date.clone();

    }

}
