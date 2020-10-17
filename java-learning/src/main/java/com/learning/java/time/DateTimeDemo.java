package com.learning.java.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo {

    public static void main(String[] args) {

        System.out.println(LocalTime.now());
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());

        // parse date and time
        String dateTime = "2020-10-14 12:30";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, dateTimeFormatter);
        System.out.println(localDateTime);
        System.out.println(localDateTime.format(dateTimeFormatter));

        Object[] a = new Object[2];
        a[0] = 1;
        a[1] = "Hello";

        for (Object item: a){
            System.out.println(item);
        }

    }

}
