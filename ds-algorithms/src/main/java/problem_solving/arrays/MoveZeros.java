package problem_solving.arrays;

// 283 - https://leetcode.com/problems/move-zeroes/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int numZeros = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]==0){
                numZeros++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            if (nums[i] != 0){
                list.add(nums[i]);
            }
        }
        while (numZeros > 0){
            list.add(0);
            numZeros--;
        }
        for (int i=0; i<list.size(); i++){
            nums[i] = list.get(i);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[] {0,1,0,3,12};
        new MoveZeros().moveZeroes(input);
        Arrays.stream(input).forEach(System.out::println);
    }

}
