package com.learning.java.interview.net_cracker.second_round;


public class Dummy {

    // select studentName, max(mark) as mark from Student where mark < max(mark)
    // group by studentName

    // empName, empId, managerId

    // empNam, managerName

    // EmpId EmpName ManId
    // 1     A       2
    // 2     B       3
    // 3     C       null

    // select e.EmpName as empName, m.EmpName as ManName from Employee e inner join
    // Employee m on e.empId=m.ManId

    // Employee      Department

    // select * from A, B

    // A    B
    // a    b
    // 1    10
    // 2    11
    // 3
    // 4
    // 5

    // Student -> StudentName marks

    // select * from Student

    // insert into Table2 (columns) values (select * from Table1 where )
}
