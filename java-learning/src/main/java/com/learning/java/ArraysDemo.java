package com.learning.java;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

    public static void main(String[] args) {

        String[] s = {"A", "B", "C"};
        List<String> sList = Arrays.asList(s);
        sList.forEach(System.out::println);

        System.out.println("Binary search in array");
        int index = Arrays.binarySearch(s, "C");
        if (index == -1)
            System.out.println("Searched element does not exist");
        else
            System.out.println("Searched element exists");

        System.out.println(Arrays.toString(s));

        System.out.println("Copying arrays");
        String[] s1 = Arrays.copyOf(s, s.length);
        System.out.println(Arrays.toString(s1));

        System.out.println("Streams from arrays");
        System.out.println(Arrays.toString(Arrays.stream(s1).filter(s2 -> s2.startsWith("A")).toArray()));

        System.out.println("Streams from int arrays");
        int[] i = {1,2,3,4,5};
        Integer[] i1 = Arrays.stream(i).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(i1));

        System.out.println("Cloning");
        String[] s2 = s1.clone();
        String[] s3 = s2;
        System.out.println("s1 hashcode : " + s1.hashCode() + " and s2 hashcode: " + s2.hashCode());
        System.out.println("s2 hashcode : " + s2.hashCode() + " and s3 hashcode: " + s3.hashCode());


    }
}
