package com.tutorials.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.tutorials.spring.annotation_domain")
@EnableScheduling
public class AnnotationConfig {
}
