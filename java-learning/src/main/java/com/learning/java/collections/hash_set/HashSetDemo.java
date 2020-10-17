package com.learning.java.collections.hash_set;

import java.util.Set;
import java.util.TreeSet;

public class HashSetDemo {

    public static void main(String[] args) {

        Set<String> set = new TreeSet<>();
        set.add("Z");
        set.add("A");
        set.forEach(System.out::println);

    }

}
