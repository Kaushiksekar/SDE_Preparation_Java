package com.tutorials.spring;

import com.tutorials.spring.config.ApplicationConfig;
import com.tutorials.spring.domain.GreetingService;
import com.tutorials.spring.domain.HelloWorld;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurableApplicationContextDemo {


    public static void main(String[] args) {
        // using ConfigurableApplicationContext as that extends Closeable interface and hence as close method
        // only if there is close, destroy would work

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
        greetingService.greet();

        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
        helloWorld.printHello();

        context.close();
    }
}
