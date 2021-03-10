package problem_solving.dynamic_programming;

import java.util.Arrays;

// 303
class NumArray {

    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length+1];
        for (int i=0; i<nums.length; i++){
            sum[i+1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}

public class RangeSumQuery {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0,5));
    }
}
