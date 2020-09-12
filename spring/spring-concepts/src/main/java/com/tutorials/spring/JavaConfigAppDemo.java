package com.tutorials.spring;

import com.tutorials.spring.config.ApplicationConfig;
import com.tutorials.spring.domain.HelloWorld;
import com.tutorials.spring.domain.VehicleComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class JavaConfigAppDemo {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        HelloWorld helloWorld = (HelloWorld) context.getBean("hloWorld");
        helloWorld.printHello();
        System.out.println(Arrays.toString(context.getAliases("hloWorld")));

        VehicleComponent vehicle = context.getBean("vehicleComponent", VehicleComponent.class);
        vehicle.move();
        System.out.println(vehicle);

        vehicle = context.getBean("vehicleComponent", VehicleComponent.class);
        System.out.println(vehicle);// hash codes will be different since bean is prototype as defined in java config

    }

}
