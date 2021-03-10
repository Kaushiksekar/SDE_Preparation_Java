package com.learning.java.optionals;

import java.util.Optional;

class User{
    String name;
    int age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public static User getUser(boolean flag){
        if (flag)
            return new User("Kaushik",15);
        else
            return null;
    }
    public String getName() {
        return name;
    }
}

public class OptionalUsageDemo {

    public static void main(String[] args) {
        Optional<User> userOptional = Optional.ofNullable(User.getUser(true));
        String result = userOptional.map(user -> user.getName()).orElse("Unknown");
        // or else will not just return if value is not there, it will return the right value if value is there
        // in this case, Kaushik will be returned, if false was passed to getUser, Unknown would be printed
        System.out.println(result);
    }
}
