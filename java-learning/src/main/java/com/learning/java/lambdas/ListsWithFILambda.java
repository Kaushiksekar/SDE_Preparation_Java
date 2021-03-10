package com.learning.java.lambdas;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface FunctionalInt{
    List<Integer> filterList(List<Integer> list);
}

public class ListsWithFILambda {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>() {{ add(1); add(2); add(3); add(4); add(5); }};
        FunctionalInt functionalInt = ListsWithFILambda::filterList;
        System.out.println(functionalInt.filterList(list));

    }

    public static List<Integer> filterList(List<Integer> list){
        return list.subList(0,1);
    }

}
