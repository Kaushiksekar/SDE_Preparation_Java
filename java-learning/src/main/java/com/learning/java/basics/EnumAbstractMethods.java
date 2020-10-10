package com.learning.java.basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum DirectionNew{
    NORTH{
        @Override
        void printDirection() {
            System.out.println("Moving in north direction");
        }
    }, SOUTH{
        @Override
        void printDirection() {
            System.out.println("Moving in south direction");
        }
    }, EAST{
        @Override
        void printDirection() {
            System.out.println("Moving in east direction");
        }
    }, WEST{
        @Override
        void printDirection() {
            System.out.println("Moving in west direction");
        }
    };

    void printDirectionInstanceMethod(){
        System.out.println("Moving in " + this + " direction");
    }

    abstract void printDirection();

}

public class EnumAbstractMethods {

    public static void main(String[] args) {

        DirectionNew direction = DirectionNew.NORTH;
        System.out.println(direction.name());
        direction.printDirection();
        direction.printDirectionInstanceMethod();

        System.out.println(Direction.valueOf("NORTH"));

        Map map = new HashMap();
        List list = new ArrayList();

    }

}
