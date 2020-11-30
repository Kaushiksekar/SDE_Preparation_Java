package com.learning.java.design_patterns.decorator;

abstract class Beverage{
    String description = "Unknown beverage";
    public String getDescription() {
        return description;
    }
    public abstract double cost();
}

abstract class CondimentDecorator extends Beverage{
    public abstract String getDescription();
}

class Espresso extends Beverage{
    public Espresso() {
        description = "Espresso";
    }
    @Override
    public double cost() {
        return 1.99;
    }
}

class HouseBlend extends Beverage{
    public HouseBlend() {
        description = "House Blend";
    }
    @Override
    public double cost() {
        return 0.89;
    }
}

class Mocha extends CondimentDecorator{
    Beverage beverage;
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}

class WhipCream extends CondimentDecorator{
    Beverage beverage;
    public WhipCream(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public double cost() {
        return beverage.cost() + 0.30;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip Cream";
    }
}

public class DecoratorPatternDemo {

    public static void main(String[] args) {
        Beverage beverage = new HouseBlend();
        System.out.println(beverage.getDescription() + " : $" + beverage.cost());
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription() + " : $" + beverage.cost());
        beverage = new WhipCream(beverage);
        System.out.println(beverage.getDescription() + " : $" + beverage.cost());
    }
}
