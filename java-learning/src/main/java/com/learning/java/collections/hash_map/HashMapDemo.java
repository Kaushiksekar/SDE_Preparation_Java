package com.learning.java.collections.hash_map;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        map.put("a", "c");
        map.put("a", "d");
        map.put("a", "e");
        map.put("a", "f");
        map.put("a", "g");
        map.put("a", "h");
        map.put("a", "i");
        map.put("a", "j");
        map.put("a", "k");
        map.put("a", "l");
        map.put("a", "m");
        map.put("a", "n");
        map.put("a", "o");
        System.out.println(map.getClass());
    }

}
