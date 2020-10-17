package com.learning.java.collections.hash_map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapSorting {

    public static void main(String[] args) {

        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("alex", 1);
        unsortMap.put("david", 2);
        unsortMap.put("elle", 3);
        unsortMap.put("charles", 4);
        unsortMap.put("brian", 5);

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEachOrdered(stringIntegerEntry ->
                        sortedMap.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue()));

        sortedMap.forEach((s, integer) -> {
            System.out.println(s);
            System.out.println(integer);
        });

    }

}
