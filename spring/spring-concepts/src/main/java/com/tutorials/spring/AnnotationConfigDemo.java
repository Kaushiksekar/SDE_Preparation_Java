package com.tutorials.spring;

import com.tutorials.spring.annotation_domain.Home;
import com.tutorials.spring.config.AnnotationConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigDemo {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        Home home = context.getBean("home", Home.class);
        home.host();

    }
}
