package com.learning.java.basics;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

public class EnumSetDemo {

    public static void main(String[] args) {

        Set<Direction> eastOrWest = EnumSet.of(
                Direction.EAST,
                Direction.WEST
        );

        System.out.println(eastOrWest);

        Map<Direction, Integer> enumMap = new EnumMap(Direction.class);
        enumMap.put(Direction.NORTH, Direction.NORTH.getAngle());
        enumMap.put(Direction.SOUTH, Direction.SOUTH.getAngle());

        System.out.println(enumMap);

    }

}
