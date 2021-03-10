package com.learning.java.interview.oracle.first_round;

import java.util.HashMap;
import java.util.Map;

public class CharOccurranceInString {

    public static Map<Character, Integer> getCharacterCount(String input){

        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<input.length(); i++){
            Character character = input.charAt(i);
            if (map.containsKey(character)){
                map.put(character, map.get(character) + 1);
            }
            else{
                map.put(character, 1);
            }
        }

        return map;
    }

    public static void main(String[] args) {

        String sampleInput = "hello";
        Map<Character, Integer> map = getCharacterCount(sampleInput);
        map.forEach((character, integer) -> {
            System.out.println(character + " : " + integer);
        });

    }

}
