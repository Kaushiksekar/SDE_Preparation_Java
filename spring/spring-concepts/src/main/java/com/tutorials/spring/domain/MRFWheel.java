package com.tutorials.spring.domain;

public class MRFWheel implements WheelComponent{
    @Override
    public void rotate() {
        System.out.println("Rotating using MRF");
    }
}
