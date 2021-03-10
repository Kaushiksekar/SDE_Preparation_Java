package com.learning.java.collections.hash_map;

import java.util.*;

public class HashMapSorting {

    public static void main(String[] args) {

        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("alex", 1);
        unsortMap.put("david", 2);
        unsortMap.put("brian", 5);
        unsortMap.put("elle", 3);
        unsortMap.put("charles", 4);

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEachOrdered(stringIntegerEntry ->
                        sortedMap.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue()));

        sortedMap.forEach((s, integer) -> {
            System.out.println(s);
            System.out.println(integer);
        });

        List<Map.Entry<String, Integer>> list = new ArrayList<>(unsortMap.entrySet());
        Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        list.forEach(stringIntegerEntry -> {
            System.out.println(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue());
        });

        list.iterator();
    }

}
