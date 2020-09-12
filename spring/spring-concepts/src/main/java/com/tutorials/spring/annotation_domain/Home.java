package com.tutorials.spring.annotation_domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Home {

    private Refrigirator refrigirator;

    public Home(@Qualifier(value = "lg") Refrigirator refrigirator) {
        this.refrigirator = refrigirator;
    }

    public void host() {
        System.out.println("Hosting at home");
        refrigirator.run();
    }

}
