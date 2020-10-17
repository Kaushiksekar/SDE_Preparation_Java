package com.learning.java.collections.hash_map;

import java.util.Hashtable;
import java.util.Map;

public class HashTableDemo {

    public static void main(String[] args) {

        Map<String, Integer> hashTable = new Hashtable<>();
        hashTable.put("A", 1);
        hashTable.put("B", 1);

        for (Map.Entry<String, Integer> entry: hashTable.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }

}
