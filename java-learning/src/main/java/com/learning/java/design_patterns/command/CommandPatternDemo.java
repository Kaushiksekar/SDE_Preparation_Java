package com.learning.java.design_patterns.command;

@FunctionalInterface
interface Command{
    void execute();
}

class Light{
    public void turnOn(){
        System.out.println("Light turned on");
    }
    public void turnOff(){
        System.out.println("Light turned off");
    }
}

class Fan{
    public void turnOn(){
        System.out.println("Fan turned on");
    }
    public void turnOff(){
        System.out.println("Fan turned off");
    }
}

class StartLightCommand implements Command{

    private Light light;

    public StartLightCommand(Light light) {
        super();
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("Starting light");
        light.turnOn();
    }
}

class StopLightCommand implements Command{

    private Light light;

    public StopLightCommand(Light light) {
        super();
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("Stopping light");
        light.turnOff();
    }
}

class StarFanCommand implements Command{

    private Fan fan;

    public StarFanCommand(Fan fan) {
        super();
        this.fan = fan;
    }

    @Override
    public void execute() {
        System.out.println("Starting fan");
        fan.turnOn();
    }
}

class StopFanCommand implements Command{

    private Fan fan;

    public StopFanCommand(Fan fan) {
        super();
        this.fan = fan;
    }

    @Override
    public void execute() {
        System.out.println("Stopping fan");
        fan.turnOff();
    }
}

class HomeAutomation{
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonPressed(){
        System.out.println("Button pressed");
        command.execute();
    }
}


public class CommandPatternDemo {

    public static void main(String[] args) {

        Light light = new Light();
        Fan fan = new Fan();
        HomeAutomation homeAutomation = new HomeAutomation();
        homeAutomation.setCommand(new StarFanCommand(fan));
        homeAutomation.buttonPressed();
        homeAutomation.setCommand(new StartLightCommand(light));
        homeAutomation.buttonPressed();
        // also give custom implementations
        homeAutomation.setCommand(() -> {
            System.out.println("Turning off fan");
            fan.turnOff();
        });


    }
}
