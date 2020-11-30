package com.learning.java.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class ProcessAnnotationExample {

    public static void main(String[] args) throws NoSuchMethodException {

        new DemoClass();
        Class<DemoClass> demoClass = DemoClass.class;
        readAnnotation(demoClass);
        Method method = demoClass.getMethod("getString");
        readAnnotation(method);
    }

    static void readAnnotation(AnnotatedElement element){
        System.out.println("Finding annotations on : " + element.getClass().getName());
        Annotation[] annotations = element.getAnnotations();
        for (Annotation annotation: annotations){
            if (annotation instanceof JavaFileInfo){
                JavaFileInfo javaFileInfo = (JavaFileInfo) annotation;
                System.out.println("Author : " + javaFileInfo.author());
                System.out.println("Version : " + javaFileInfo.version());
            }
        }
    }

}
