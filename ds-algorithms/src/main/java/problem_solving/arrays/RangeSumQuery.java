package problem_solving.arrays;

import java.util.Arrays;

class NumArray {

    private int nums[];

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        return Arrays.stream(Arrays.copyOfRange(nums, i, j+1)).sum();
    }
}

public class RangeSumQuery {

    public static void main(String[] args) {
        int nums[] = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0,5));
    }
}
