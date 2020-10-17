package com.learning.java.collections.hash_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class ImmutablePerson{

    private final int id;
    private String name;

    public ImmutablePerson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImmutablePerson that = (ImmutablePerson) o;

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
}

public class ImmutableObjectsHashcode {

    public static void main(String[] args) {

        ImmutablePerson object = new ImmutablePerson(1, "Kaushik");
        Map<ImmutablePerson, Integer> map = new HashMap<>();
        map.put(object, 27);
        object.setName("Sony");
        System.out.println(map.get(object));
        // even though name is changed, hashcode is not computed using name, hence getting
        // from hashmap still works

    }

}
