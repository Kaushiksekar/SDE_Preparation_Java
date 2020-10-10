package com.learning.java.basics;

import org.apache.commons.lang3.SerializationUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysDemo {

    public static void main(String[] args) {

        ArrayList<String>[] a = new ArrayList[1];
        a[0] = new ArrayList<>(){{add("a");}};
        System.out.println(a.toString());

        System.out.println((new int[1]).getClass().getName());


        // print array for 1 day array
        String[] s = {"a", "b"};
        System.out.println(Arrays.toString(s));

        // shallow copy
        int[] oneDArr1 = {1, 2};
        int[] oneDArr2 = {3, 4};

        int[][] twoDArr1 = {oneDArr1, oneDArr2};
        oneDArr1[0] = -9999;
        for (int[] i: twoDArr1){
            for (int j: i){
                System.out.println(j);
            }
        }

        // deep copy
        int[] oneDArr3 = {1, 2};
        int[] oneDArr4 = {3, 4};

        int [][] twoDArr2 = {SerializationUtils.clone(oneDArr3), SerializationUtils.clone(oneDArr4)};
        oneDArr1[0] = -9999;
        for (int[] i: twoDArr2){
            for (int j: i){
                System.out.println(j);
            }
        }
        // print array for 2d arrays
        System.out.println(Arrays.deepToString(twoDArr2));

        int[] array2 = new int[3];
        int[][] array1 = new int[3][3];
        array1[0] = new int[]{1, 2, 3};
//        array1[0][3]= -999; // this is error
        array1[1] = new int[]{4, 5};
        array1[2] = new int[]{6,7,8,9}; // irrespective of len of inner array, we can assign values
        array1[2][3] = -999; // this will work because size of array1[2] is 4
        System.out.println(Arrays.deepToString(array1));

    }
}
