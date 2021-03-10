package problem_solving.arrays;

// 53

import problem_solving.dynamic_programming.MaxSubArrayFromArray;

public class MaxSubArrayRevision {

    public static void main(String[] args) {
        System.out.println(new MaxSubArrayRevision().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArray(int[] ints) {
        if (ints.length == 0)
            return 0;
        int maxSum = ints[0];

        for (int i=1; i<ints.length; i++){
            if (ints[i-1] > 0){
                ints[i] += ints[i-1];
            }
            maxSum = Math.max(ints[i], maxSum);
        }
        return maxSum;
    }
}
