package com.learning.java.serialization;

import java.io.Serializable;

public class POJO implements Serializable {

    int a;
    String b;
    static int c;
    transient String d;

    public POJO(int a, String b, String d, int c) {
        this.a = a;
        this.b = b;
        this.d = d;
        POJO.c = c;
    }
}
