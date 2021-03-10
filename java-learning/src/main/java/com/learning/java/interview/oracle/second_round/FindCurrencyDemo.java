package com.learning.java.interview.oracle.second_round;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindCurrencyDemo {

//    findCurrecy()
//    Input : 7540
//    Expected Output: 1000: 7, 100: 5, 10 : 4
//    This number dynami

    static Map<Integer, Integer> findCurrency(Integer value){
        Map<Integer, Integer> map = new LinkedHashMap<>();
        String valueString = String.valueOf(value);
        for(int i=0; i<valueString.length()-1; i++){
            int numZeros = valueString.substring(i+1).length();
            StringBuilder position = new StringBuilder("1");
            while(numZeros > 0){
                position.append(0);
                numZeros--;
            }
            map.put(Integer.valueOf(position.toString()), Integer.valueOf(String.valueOf(valueString.charAt(i))));
        }
        return map;
    }

    public static void main(String[] args) {
        Integer input = 7540;
        Map<Integer, Integer> map = findCurrency(input);
        map.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }
}

//Table = Employee, c1: Name, c2: Age. C3: city
//        Find the 2nd hig
//        Highest age row

// select e.Name, max(e.Age), e.city from Employee as e where e.Age < max(e.Age) group by e.Name, e.city

// City = null
//Can u write update query to bangalore

// update Employee as e set e.city='bangalore' where e.city is null
