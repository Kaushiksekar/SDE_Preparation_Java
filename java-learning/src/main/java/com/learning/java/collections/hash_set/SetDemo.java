package com.learning.java.collections.hash_set;

import java.util.*;

public class SetDemo {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("Kaushik");
        set.add("Abhi");
        set.add("Ashwin");
        set.add("Dheeraj");

        SortedSet<String> set1 = new TreeSet<>(set);
        System.out.println(set1.first());
        System.out.println(set1.last());
        System.out.println(set1.headSet("Dheeraj"));
        System.out.println(set1.tailSet("Ashwin"));
        System.out.println(set1.subSet("Ashwin", "Kaushik"));

    }
}
