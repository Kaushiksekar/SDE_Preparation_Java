package com.learning.java.interview.oracle.second_round;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Table(name="")
//@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    // Primary Key = Name+ age+city
    //Can you please write an entity class with proper mapping and annotcation

//    @Id
    private int id;

    private String name;

    private String age;

    private String city;
}
