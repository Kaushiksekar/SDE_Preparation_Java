package com.learning.java.exceptions;

public class Demo1 {

    public static void main(String[] args) throws Exception {
//        try{
//            System.out.println("inside try block");
//            throw new Exception("");
//        }
//        finally { // either atleast 1 catch block should be there or finally block
//            System.out.println("Exception thrown");
//        }

        hello(); // terminates here
        throw new Exception();

    }

    static void hello(){
        throw new NullPointerException();
    }
}
