package com.learning.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo1 {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[A-Z]\\S*[0-9]+[a-z0-9_]*\\S*");
        Matcher matcher = pattern.matcher("Theory Bell_99 Imagina4tion");
        while(matcher.find()){
            System.out.println("Found starting at index : " + matcher.start());
            System.out.println("Found ending at index : " + matcher.end());
            System.out.println("Word: " + matcher.group());
            System.out.println();
        }

    }
}
