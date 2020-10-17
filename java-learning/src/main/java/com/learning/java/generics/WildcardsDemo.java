package com.learning.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardsDemo {

    public static void main(String[] args) {

        List<?> collection = new ArrayList<String>();
        collection.add(null);//you can only insert null into a List<?>

        List<?> list = Arrays.asList(1,2,3, "asdasd");
        System.out.println(list);

        List<Integer> integerList = new ArrayList<>(2) {{ add(10); add(20); }};
//        hello(integerList); // this cannot be called because it only accepts list of objects
        // and List<Integer> is not a subtype of List<Object>
        // You can put integer inside list of objects because Integer is a subtype of Object
        // but you cannot pass List<Integer> where List<Object> is expected
        // because as mentioned, List<Integer> is not a subtype of List<Object>

        helloWildcard(integerList);

        List<Double> doubleList = new ArrayList<>(2) {{ add(1.5); add(2.5); }};
        helloWildcard(doubleList);

        List<String> stringList = new ArrayList<>(2) {{ add("asda"); add("xcvdcfc"); }};
        helloWildcard(stringList);

    }

    static void hello(List<Object> objects){
        for (Object i: objects){
            System.out.println(i);
        }
    }

    static void helloWildcard(List<?> objects){
        for (Object i: objects){
            System.out.println(i);
        }
    }

}
