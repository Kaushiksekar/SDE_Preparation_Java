package com.learning.java.interfaces;

interface MBVehicle{
    default String getName(){
        return "Unknown Vehicle";
    }
}

interface SedanVehicle{
    default String getName(){
        return "Unknow Sedan";
    }
}

class V226 implements MBVehicle, SedanVehicle{
    @Override
    public String getName(){
        return "V226";
    }
}

public class DefaultMethodsInInterfaceDemo {

    public static void main(String[] args) {
        System.out.println(new V226().getName());
    }
}
