package com.learning.java.interfaces.function_interfaces;

import java.util.stream.Stream;

@FunctionalInterface
interface Bar{
    String method(String string);
    default String defaultCommon(){
        return "common bar";
    }
}

@FunctionalInterface
interface Baz{
    String method(String string);
    default String defaultCommon(){
        return "common baz";
    }
}

@FunctionalInterface
interface Foo extends Bar, Baz{
    // if this is not overriden, it is a compiler error as compiler would not know which implementation to pick
    @Override
    default String defaultCommon() {
        return Bar.super.defaultCommon();
    }
}

@FunctionalInterface
interface ObjectInstanceMethod2Para{
    String method(String a, String b);
}

@FunctionalInterface
interface ObjectInterfaceMethod3Param{
    String method(String a, String b, String c);
}

class Person{
    String name;
    public Person(String name) {
        this.name = name;
    }
}

public class FunctionalInterfaceDemo {

    public static void main(String[] args) {

        String a = "hello";
        Foo foo = a::concat;
        System.out.println(foo.method(" hi"));
        Foo foo1 = String::toLowerCase;

        ObjectInstanceMethod2Para object = String::concat; // this is equivalent to a.concat(b)
        System.out.println(object.method("Kaushik", " Sekar"));
        String item = "asdas";
        object = item::replace; // equivalent to item.replace(a,b)
        System.out.println(object.method("a", "A"));

        ObjectInterfaceMethod3Param object1 = String::replace;
        System.out.println(object1);
        System.out.println(object1.method("KaushikSekar", "Sekar", " Sekar"));

        Stream<String> stringStream = Stream.of("Kaushik", "Sony");
        Stream<Person> personStream = stringStream.map(Person::new);
        personStream.forEach(person -> System.out.println(person.name));

    }
}
