package com.learning.java.basics;

import org.apache.commons.lang3.SerializationUtils;

import java.util.Arrays;

public class ShallowCopy {

    public static void main(String[] args) {

        int[][] oneDArr1 = new int[2][];
        int[] arr1 = {1,2};
        int[] arr2 = {3,4};
        oneDArr1[0] = arr1;
        oneDArr1[1] = arr2;
        //all below types are shallow copy
        int[][] oneDArr2 = oneDArr1.clone();
        int[][] oneDArr3 = Arrays.copyOf(oneDArr1, oneDArr1.length);
        int[][] oneDArr4 = new int[2][];
        System.arraycopy(oneDArr1, 0, oneDArr4, 0, oneDArr1.length);
        //deep copy
        int[][] oneDArr5 = SerializationUtils.clone(oneDArr1);
        // deep copy will also be done for 1d arrays by Arrays.copyOf
        int[][] oneDArr6 = new int[2][];
        for (int i=0; i< oneDArr1.length; i++){
            oneDArr6[i] = Arrays.copyOf(oneDArr1[i], oneDArr1[i].length);
        }
        arr1[0] = -1;
        System.out.println(Arrays.deepToString(oneDArr2));
        System.out.println(Arrays.deepToString(oneDArr3));
        System.out.println(Arrays.deepToString(oneDArr4));
        System.out.println(Arrays.deepToString(oneDArr5));
        System.out.println(Arrays.deepToString(oneDArr6));

    }
}
