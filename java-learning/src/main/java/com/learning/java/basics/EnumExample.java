package com.learning.java.basics;

enum Direction{
    NORTH(0), SOUTH(180), EAST(90), WEST(270);

    private int angle;

    Direction(int angle) {
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
}

public class EnumExample {

    public static void main(String[] args) {

        Direction direction = Direction.NORTH;
        System.out.println(direction.ordinal());
        Direction east = Direction.EAST;
        System.out.println(east.getAngle());

    }

}
