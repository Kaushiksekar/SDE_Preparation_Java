package com.tutorials.spring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class VehicleComponent {

//    @Autowired
//    @Qualifier("mrfWheel")
    WheelComponent wheel;

    public VehicleComponent(WheelComponent wheel) {
        this.wheel = wheel;
    }

    public void move(){
        wheel.rotate();
    }

}
