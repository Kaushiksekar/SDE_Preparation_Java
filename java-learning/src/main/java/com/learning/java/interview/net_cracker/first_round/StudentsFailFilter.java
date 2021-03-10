package com.learning.java.interview.net_cracker.first_round;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

class Student{
    String name;
    float marks;
    public Student(String name, float marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentsFailFilter {

    public static void filterFailedStudents(List<Student> studentList){
        Iterator<Student> studentIterator = studentList.iterator();
//        while (studentIterator.hasNext()){
//            Student student = studentIterator.next();
//            if (student.marks < 40)
//                studentIterator.remove();
//        }
        int counter = 0;
        while(counter < studentList.size()){
            if (studentList.get(counter).marks < 40)
                studentList.remove(counter);
            counter++;
        }
    }

    public static List<Student> sortByMarks(List<Student> studentList){
        return studentList.stream().sorted((o1, o2) -> {
            if (o1.marks < o2.marks)
                return -1;
            else if (o1.marks > o2.marks)
                return 1;
            return 0;
        }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(){{
            add(new Student("C", 65));
           add(new Student("A", 45));
           add(new Student("B", 35));
           add(new Student("D", 25));
        }};
        filterFailedStudents(list);
        for (Student student : list){
            System.out.println(student.name);
        }
        System.out.println("After sorting");
        sortByMarks(list).forEach(student -> System.out.println(student.name));
    }
}

//Employee
//emp_id  emp_name    manager_id
//1       A           3
//2       B           3
//3       D           null
//
//select m.emp_id, m.emp_name, count(e.id) from Employee e inner join Employee m on
//        e.manager_id = m.id group by m.emp_id, m.emp_name