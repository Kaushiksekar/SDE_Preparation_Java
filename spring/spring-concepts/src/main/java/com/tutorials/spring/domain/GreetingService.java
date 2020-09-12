package com.tutorials.spring.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class GreetingService implements InitializingBean, DisposableBean, BeanPostProcessor {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After setting up bean");
    }

    public void greet(){
        System.out.println("Greetings!");
    }

    // destroy callbacks would does not work for prototype beans for which custom destroy should be written
    @Override
    public void destroy() throws Exception {
        System.out.println("Before tearing down bean");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Dummy post processing before initialization of bean: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Dummy post processing after initialization of bean: " + beanName);
        return bean;
    }
}
