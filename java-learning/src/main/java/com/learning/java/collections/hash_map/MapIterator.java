package com.learning.java.collections.hash_map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIterator {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("A", "B");
        map.put("B", "C");
        map.put("D", "E");
        map.put("C", "D");

        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String nextItem = iterator.next();
            if (nextItem.equals("A")){
                iterator.remove();
            }
        }

        System.out.println(map);

        // can also iterate with entryset

        Iterator<Map.Entry<String, String>> entryIterator = map.entrySet().iterator();

        while(entryIterator.hasNext()){
            Map.Entry<String, String> mapItem = entryIterator.next();
            if (mapItem.getKey().equals("B")){
                entryIterator.remove();
            }
        }

        System.out.println(map);


    }
}
