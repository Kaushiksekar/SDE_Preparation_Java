package com.learning.java.design_patterns.factory;

enum CarType{
    SMALL, SEDAN, LUXURY
}

abstract class Car{
    private CarType model;

    public Car(CarType model) {
        this.model = model;
        arrangeParts();
    }

    public abstract void construct();

    public void arrangeParts(){
        //
    }

    public CarType getModel() {
        return model;
    }

    public void setModel(CarType model) {
        this.model = model;
    }
}

class SmallCar extends Car{


    public SmallCar() {
        super(CarType.SMALL);
        construct();

    }

    @Override
    public void construct() {
        System.out.println("Building small cars");
    }
}

class SedanCar extends Car{
    public SedanCar() {
        super(CarType.SEDAN);
        construct();
    }

    @Override
    public void construct() {
        System.out.println("Building sedan cars");
    }
}

class LuxuryCar extends Car{
    public LuxuryCar() {
        super(CarType.LUXURY);
        construct();
    }

    @Override
    public void construct() {
        System.out.println("Building luxury cars");
    }
}

class CarFactory{

    public static Car buildCar(CarType model){
        switch (model){
            case SMALL:
                return new SmallCar();
            case SEDAN:
                return new SedanCar();
            case LUXURY:
                return new LuxuryCar();
            default:
                throw new RuntimeException("Unacceptable car type given");
        }
    }

}

public class CarFactoryDemo {

    public static void main(String[] args) {
        Car car = CarFactory.buildCar(CarType.LUXURY);
    }
}
