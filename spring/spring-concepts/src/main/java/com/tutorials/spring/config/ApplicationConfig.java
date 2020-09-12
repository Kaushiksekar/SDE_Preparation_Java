package com.tutorials.spring.config;

import com.tutorials.spring.domain.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {

    @Bean(value = {"hloWorld", "helloWorld", "greetingWorld"}, initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
    public HelloWorld helloWorld(){
        return new HelloWorld();
    }

    @Bean
    @Scope("prototype")
    // mrfWheel is being autowired into the bean as by default byType autowiring is enabled for java config
    public VehicleComponent vehicleComponent(@Qualifier("mrfWheel") WheelComponent wheel){
        return new VehicleComponent(wheel);
    }

    @Bean(name = "mrfWheel")
    public MRFWheel mrfWheel() {
        return new MRFWheel();
    }

    @Bean(name = "unknownWheel")
    public UnknownWheel unknownWheel() {
        return new UnknownWheel();
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingService();
    }
}
