package com.tutorials.spring.domain;

public class UnknownWheel  implements WheelComponent{
    @Override
    public void rotate() {
        System.out.println("Rotating using unknown wheel");
    }
}
