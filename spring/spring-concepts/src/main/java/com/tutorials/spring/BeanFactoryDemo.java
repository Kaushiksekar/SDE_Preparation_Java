package com.tutorials.spring;

import com.tutorials.spring.domain.HelloWorld;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanFactory.xml"));
        HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("helloWorld");
        helloWorld.printHello();

        System.out.println("The bean factory contains helloWorld bean : " + beanFactory.containsBean("helloWorld"));
        System.out.println("The helloWorld bean is singleton : " + beanFactory.isSingleton("helloWorld"));

    }
}
