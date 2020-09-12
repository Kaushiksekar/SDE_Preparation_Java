package com.tutorials.spring.annotation_domain;

import org.springframework.stereotype.Component;

@Component(value = "lg")
public class LG implements Refrigirator {
    @Override
    public void run() {
        System.out.println("Running refrigirator using LG");
    }
}
