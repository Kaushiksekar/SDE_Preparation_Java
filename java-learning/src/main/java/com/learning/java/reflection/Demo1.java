package com.learning.java.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

enum Status{
    RUNNING, EXITED

}

public class Demo1 {

    public int getInteger(){
        return 1;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = new Demo1().getClass().getMethod("getInteger", null);
        System.out.println(method.invoke(new Demo1()));
        System.out.println(Status.EXITED.equals(Status.RUNNING));
        Demo1 demo1 = new Demo1();
        Demo1 demo2 = new Demo1();
        demo1.equals(demo2);
    }
}
