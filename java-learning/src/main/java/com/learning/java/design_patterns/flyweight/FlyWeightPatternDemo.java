package com.learning.java.design_patterns.flyweight;

import java.util.HashMap;

interface Pen{
    public void setColor(String color);
    public void draw(String content);
}

enum BrushSize{
    THICK, MEDIUM, THIN
}

class ThickPen implements Pen{
    private BrushSize brushSize = BrushSize.THICK;
    private String color;
    @Override
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public void draw(String content) {
        System.out.println("Drawing thick content in color : " + color);
    }
}

class MediumPen implements Pen{
    private BrushSize brushSize = BrushSize.MEDIUM;
    private String color;
    @Override
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public void draw(String content) {
        System.out.println("Drawing medium content in color : " + color);
    }
}

class ThinPen implements Pen{
    private BrushSize brushSize = BrushSize.THIN;
    private String color;
    @Override
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public void draw(String content) {
        System.out.println("Drawing thin content in color : " + color);
    }
}

class PenFactory{
    private static HashMap<String, Pen> pensMap = new HashMap<>();
    public static Pen getThickPen(String color){
        String key = color + "-THICK";
        Pen pen = pensMap.get(key);
        if (pen == null){
            pen = new ThickPen();
            pen.setColor(color);
            pensMap.put(key, pen);
        }
        return pen;
    }
    public static Pen getMediumPen(String color){
        String key = color + "-MEDIUM";
        Pen pen = pensMap.get(key);
        if (pen == null){
            pen = new MediumPen();
            pen.setColor(color);
            pensMap.put(key, pen);
        }
        return pen;
    }
    public static Pen getThinPen(String color){
        String key = color + "-THIN";
        Pen pen = pensMap.get(key);
        if (pen == null){
            pen = new ThinPen();
            pen.setColor(color);
            pensMap.put(key, pen);
        }
        return pen;
    }
}

public class FlyWeightPatternDemo {
    public static void main(String[] args) {
        Pen pen = PenFactory.getThickPen("YELLOW");
        pen.draw("Hello World!");
        Pen pen1 = PenFactory.getThickPen("YELLOW");
        pen1.draw("Hello World2!");
        System.out.println(pen==pen1);
        Pen pen2 = PenFactory.getThickPen("PINK");
        pen2.draw("Hello World3!");
        System.out.println(pen1==pen2);
    }
}
