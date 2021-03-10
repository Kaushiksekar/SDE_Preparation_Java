package com.learning.java.streams;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsCreation {
    public static void main(String[] args) {
        Stream.of(1,2,3);
        Stream.of(new Integer[] {1,3,5});
        Stream.generate(() -> new Random().nextInt(100)).limit(20);

        IntStream intStream = "ABCD".chars();
        intStream.forEach(System.out::println);
        intStream.forEach(value -> System.out.println(Character.toString(value))); // only once can a stream be used
    }
}
