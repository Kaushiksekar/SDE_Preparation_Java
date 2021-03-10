package com.learning.java.optionals;

import java.util.Optional;

public class OptionalsBasicsDemo {
    public static void main(String[] args) {
        Optional<Integer> optional = Optional.of(5);
        System.out.println(optional.isPresent());
        Optional<Integer> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.isEmpty());
        emptyOptional.ifPresent(System.out::println);
        System.out.println(emptyOptional.orElse(5));
        emptyOptional.orElseThrow(ArithmeticException::new); // this will throw Arithmetic exception

        optional.filter(integer -> integer > 18).ifPresent(System.out::println);

        // of nullable
        Optional<Integer> o = Optional.ofNullable(5);
        System.out.println(o.get());



    }
}
