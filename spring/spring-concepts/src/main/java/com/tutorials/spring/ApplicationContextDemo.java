package com.tutorials.spring;

import com.tutorials.spring.domain.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextDemo {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanFactory.xml");
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorld.printHello();

    }
}
