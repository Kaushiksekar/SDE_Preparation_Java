package com.learning.java.generics;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundWildCards {

    public static void main(String[] args) {

        List<SuperClass> superClassList = new ArrayList<>() {{ add(new SuperClass()); new SuperClass(); }};
        addNewObject(superClassList);

        List<ChildClass> childClassList = new ArrayList<>() {{ add(new ChildClass()); new ChildClass(); }};
        addNewObject(childClassList);

        List<GrandChildClass> grandChildClassesList = new ArrayList<>() {{ add(new GrandChildClass()); new GrandChildClass(); }};
//        addNewObject(grandChildClassesList); // this is not allowed as addNewObject has a lower limit of ChildClass

    }

    // lets say we want to only accept till ChildClass level
    static void addNewObject(List<? super ChildClass> childClassList){
        childClassList.add(new ChildClass());
        System.out.println(childClassList);
    }

}

class SuperClass{}

class ChildClass extends SuperClass{}

class GrandChildClass extends ChildClass{}