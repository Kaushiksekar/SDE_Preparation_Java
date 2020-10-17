package com.learning.java.generics;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildCards {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>() {{ add(1); add(2); }} ;
        sum(integerList);

        List<Double> doubleList = new ArrayList<>() {{ add(1.5); add(5.65); }};
        sum(doubleList);

        List<String> stringList = new ArrayList<>() {{ add("string"); add("string23"); }};
//        sum(stringList); // this won't work as sum method expects type number

        // this is called upper bound wildcard as we place an upper limit on the type
        // Number is the upper most limit here. Hence string is not valid

    }

    static Number sum(List<? extends Number> list){

        double s = 0.0;
        for (Number number: list){
            s += number.doubleValue();
        }
        return s;
    }

}
