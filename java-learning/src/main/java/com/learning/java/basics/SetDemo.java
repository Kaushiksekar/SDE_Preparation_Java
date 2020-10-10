package com.learning.java.basics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {

        Integer[] a = {0,1,2,3,4};
        Integer[] b = {0,1};

        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(a));
        set.retainAll(Arrays.asList(b));
        set.stream().forEach(System.out::println);

        // remove duplicates maintaining order
        Integer[] c = {0,4,1,1,1,2,3,4,5,3,3,334,4};
        Set<Integer> set1 = new LinkedHashSet<>();
        set1.addAll(Arrays.asList(c));
        Integer[] d = set1.toArray(new Integer[] {});
        System.out.println(Arrays.deepToString(d));

    }
}
