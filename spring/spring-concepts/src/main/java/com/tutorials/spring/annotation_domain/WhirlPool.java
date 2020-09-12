package com.tutorials.spring.annotation_domain;

import org.springframework.stereotype.Component;

@Component
public class WhirlPool implements Refrigirator {
    @Override
    public void run() {
        System.out.println("Running refrigirator on Whirlpool");
    }
}
