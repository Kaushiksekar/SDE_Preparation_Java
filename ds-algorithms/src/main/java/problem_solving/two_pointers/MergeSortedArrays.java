package problem_solving.two_pointers;

// problem no 88 -> https://leetcode.com/problems/merge-sorted-array/

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {

        int[] nums1 =  new int[] {4,5,6,0,0,0};
//        new MergeSortedArrays().merge(nums1, 3, new int[]{2,5,6}, 3);
//        new MergeSortedArrays().merge(nums1, 0, new int[]{1}, 1);
        new MergeSortedArrays().merge(nums1, 3, new int[]{1,2,3}, 3);
        Arrays.stream(nums1).forEach(System.out::println);

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m = m - 1;
        n = n - 1;
        while(n >= 0){
            if (m < 0 || nums1[m] < nums2[n]){
                nums1[m+n+1] = nums2[n];
                n -= 1;
            }
            else{
                nums1[m+n+1] = nums1[m];
                m -= 1;
            }
        }
    }

}
