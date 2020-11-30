package problem_solving.arrays;

import java.util.Arrays;

public class MoveZerosOptimized {

    public void moveZeroes(int[] nums) {
        // just swap 0s with non zero values when non zero values are found
        int lastNonZero = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] != 0){
                int temp = nums[lastNonZero];
                nums[lastNonZero] = nums[i];
                nums[i] = temp;
                lastNonZero++;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = new int[] {0,1,0,3,12};
        new MoveZerosOptimized().moveZeroes(input);
        Arrays.stream(input).forEach(System.out::println);
    }

}
