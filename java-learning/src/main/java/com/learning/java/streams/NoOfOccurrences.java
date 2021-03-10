package com.learning.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NoOfOccurrences {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(5);list.add(6);list.add(7);list.add(5);list.add(6);list.add(7);list.add(5);list.add(6);
        Map<Integer, Long> map = list.stream().collect
                (Collectors.groupingBy(integer -> integer, Collectors.counting()));
        System.out.println(map);



    }
}
