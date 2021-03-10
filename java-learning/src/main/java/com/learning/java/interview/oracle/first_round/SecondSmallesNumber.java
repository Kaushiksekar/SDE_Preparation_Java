package com.learning.java.interview.oracle.first_round;

public class SecondSmallesNumber {

    public static int findSecondSmallestNumber(int[] arr){

        int smallest = -9999;
        int secondSmallest = -9999;

        if (arr.length == 0){
            throw new RuntimeException("Array size should be atleast 1");
        }
        else if(arr.length == 1){
            throw new RuntimeException("Second smallest element cannot be found in an array of size 1");
        }

        for (int i=0; i<arr.length; i++){
            if (i == 0){
                smallest = arr[0];
                secondSmallest = arr[0];
            }
            else{ // 5, 2, 3, 1, 7
                if (arr[i] < smallest){
                    secondSmallest = smallest;
                    smallest = arr[i];
                }
                else if (arr[i] > smallest && arr[i] < secondSmallest){
                    secondSmallest = arr[i];
                }
            }
        }

//        for (int i=0; i< arr.length; i++){
//            if (i == 0){
//                smallest = arr[0];
//                secondSmallest = arr[0];
//            }
//            else{
//                if (arr[i] < smallest){
//                    smallest = arr[i];
//                }
//            }
//        }

//        System.out.println(smallest);

//        for (int i=0; i<arr.length; i++){
//            if (arr[i] > smallest && arr[i] <= secondSmallest){
//                secondSmallest = arr[i];
//            }
//        }


        return secondSmallest;
    }

    public static void main(String[] args) {

        int[] arr = new int[5];
        arr[0] = 5;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 1;
        arr[4] = 7;

        int result = findSecondSmallestNumber(arr);
        System.out.println(result);

    }
}
