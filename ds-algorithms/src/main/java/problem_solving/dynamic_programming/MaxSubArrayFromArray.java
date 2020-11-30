package problem_solving.dynamic_programming;

// 53 maximum subarray

public class MaxSubArrayFromArray {

    public static void main(String[] args) {

        System.out.println(new MaxSubArrayFromArray().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));

    }

    public int maxSubArray(int[] nums) {

        if (nums.length == 0)
            return 0;
        int maxSum = nums[0];

        for(int i=1; i<nums.length; i++){
            if (nums[i-1] > 0){
                nums[i] += nums[i-1];
            }
            maxSum = Math.max(maxSum, nums[i]);
        }
        return maxSum;
    }

}
