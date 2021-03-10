package com.learning.java.collections;

import java.util.*;
import java.util.stream.Collectors;

public class SortingMapDemo {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("Kaushik", 27);
        map.put("Dad", 60);
        map.put("Mom", 49);
        map.put("Sister", 25);

        map = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (integer, integer2) ->
                        integer, LinkedHashMap::new));
        System.out.println(map);


        List<Student> list = new ArrayList<>(){{
            add(new Student("C", 65));
            add(new Student("A", 25));
            add(new Student("B", 35));
            add(new Student("D", 25));
        }};

        Map<Float, List<Student>> list1 = list.stream().collect(Collectors.groupingBy(Student::getMarks));
        System.out.println(list1);
    }
}


class Student{
    String name;
    float marks;
    public Student(String name, float marks) {
        this.name = name;
        this.marks = marks;
    }
    public float getMarks() {
        return marks;
    }
}
