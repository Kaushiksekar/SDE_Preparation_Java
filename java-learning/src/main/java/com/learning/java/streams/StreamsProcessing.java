package com.learning.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsProcessing {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>() {{add(1);add(25);add(30);add(5);add(19);add(12);}};
        List<Integer> list1 = list.stream().filter(integer -> integer > 18).collect(Collectors.toList());
        list1.forEach(System.out::println);

        list1 = list1.stream().map(integer -> integer * integer).collect(Collectors.toList());
        list1.forEach(System.out::println);

        list1 = list1.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        list1.forEach(System.out::println);

        Optional<Integer> optionalInteger = list1.stream().reduce((integer, integer2) -> integer + integer2);
        System.out.println(optionalInteger.orElse(-1));

        List<List<Integer>> lists = new ArrayList<>(){{
           add(new ArrayList<>() {{add(1);add(5);add(-7);}});
            add(new ArrayList<>() {{add(2);add(4);add(-6);}});
            add(new ArrayList<>() {{add(3);add(6);add(-9);}});
        }};

        list1 = lists.stream().flatMap(integers -> integers.stream()).collect(Collectors.toList());
        System.out.println(list1);

        Integer[] integers = list1.stream().toArray(Integer[]::new);
        for(int integer: integers)
            System.out.print(integer + "->");
        System.out.println();

    }
}
