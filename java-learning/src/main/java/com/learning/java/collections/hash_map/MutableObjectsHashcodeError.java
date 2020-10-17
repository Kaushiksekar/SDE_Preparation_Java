package com.learning.java.collections.hash_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Person{

    String name;

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + name.length();
        return result;
    }
}

public class MutableObjectsHashcodeError {

    public static void main(String[] args) {

        Person p = new Person("Kaushik");
        Map<Person, Integer> map = new HashMap<>();
        map.put(p, 27);
        p.setName("Sony");
        System.out.println(map.get(p)); // since hashcode method of Person depends on length of string,
        // when name changes, hashcode changes and hence value of get from hashmap is null
        // this can be avoided by using constant field like personID while calculating hashcode
        // or make the Person class Immutable
    }
}
