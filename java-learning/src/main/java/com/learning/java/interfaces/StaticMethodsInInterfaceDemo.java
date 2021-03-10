package com.learning.java.interfaces;

interface MercedesVehicle{
    static String producer() {
        return "Daimler Cars";
    }
    String getName();
}

class V223 implements MercedesVehicle{

    @Override
    public String getName() {
        return "VL223";
    }
}

public class StaticMethodsInInterfaceDemo {

    public static void main(String[] args) {
        MercedesVehicle vl223 = new V223();
        System.out.println(MercedesVehicle.producer());
        System.out.println(vl223.getName());
    }
}
