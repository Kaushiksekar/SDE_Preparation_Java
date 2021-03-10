package com.learning.java.collections;

import java.util.*;

public class AddWhileIterationDemo {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("Kaushik");
        stringList.add("Sony");

        // this throws a concurrent modification exception
//        for (String string: stringList){
//            if (string.equals("Kaushik")){
//                stringList.add("One more");
//            }
//            System.out.println(string);
//        }

        // if you want to add while iterating, use list iterator
        ListIterator<String> listIterator = stringList.listIterator();
        while(listIterator.hasNext()){
            String name = listIterator.next();
            if (name.equals("Kaushik")){
                listIterator.add("One more");
            }
            System.out.println(name);
        }
        System.out.println(stringList);

        listIterator = stringList.listIterator();
        while(listIterator.hasNext()){
            String name = listIterator.next();
            if (name.equals("Kaushik")){
                listIterator.remove();
            }
            System.out.println(name);
        }
        System.out.println(stringList);

        stringList.add("ABCD");
        System.out.println(stringList);
        Collections.sort(stringList);
        System.out.println(stringList);
        Collections.sort(stringList, Comparator.reverseOrder());
        System.out.println(stringList);
    }
}
