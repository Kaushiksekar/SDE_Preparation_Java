package com.learning.java.collections.iterators;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Spliterator<String> stringSpliterator1 = list.spliterator();
        while(stringSpliterator1.tryAdvance(System.out::println)){
        }

        System.out.println("--------");

        stringSpliterator1 = list.spliterator();
        Spliterator<String> stringSpliterator2 = stringSpliterator1.trySplit();
        stringSpliterator1.forEachRemaining(System.out::println);
        System.out.println("==========");
        stringSpliterator2.forEachRemaining(System.out::println);

    }

}
