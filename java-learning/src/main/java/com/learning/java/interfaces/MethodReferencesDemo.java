package com.learning.java.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class User{
    boolean isRealUser(String userName){
        return !userName.equals("Dummy");
    }
    static boolean isLegalName(String userName){
        return !userName.startsWith("1");
    }
}

class Citizen{
    String name;
    int age;
    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }
    boolean isVoter(){
        return age >= 18;
    }
    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class MethodReferencesDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Dummy");list.add("Kaushik");list.add("Sony");list.add("1ABCD");list.add(" ");
        System.out.println(list.stream().filter(User::isLegalName).collect(Collectors.toList()));
        User user = new User();
        System.out.println(list.stream().filter(user::isRealUser).collect(Collectors.toList()));
        System.out.println(list.stream().filter(String::isBlank).collect(Collectors.toList()));
        List<Citizen> list2 = new ArrayList<>();
        list2.add(new Citizen("Kaushik", 27));list2.add(new Citizen("ABCD", 15));
        System.out.println(list2.stream().filter(Citizen::isVoter).collect(Collectors.toList()));
    }
}
