package com.learning.java.collections.array_lists;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayListDemo1 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0, 2);
        list.add(1);list.add(2);
        System.out.println(list);

        System.out.println("Adding collection to array list");
        Set<Integer> set = new HashSet<>();
        set.add(5);set.add(7);set.add(9);set.add(11);
        list.addAll(set);
        System.out.println(list);

        System.out.println("Binary Search");
        Collections.sort(list);
        list.sort(Comparator.naturalOrder()); // this is the same
        System.out.println(Collections.binarySearch(list, 5));

        System.out.println(list.stream().collect(Collectors.groupingBy(integer -> integer, Collectors.counting())));

    }
}
