package problem_solving.arrays;

// 1630 - https://leetcode.com/problems/arithmetic-subarrays/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for (int i=0; i<l.length; i++){
            int[] question = Arrays.copyOfRange(nums, l[i], r[i]+1);
            Arrays.sort(question);
            int diff = question[1]-question[0];
            boolean flag = true;
            for (int j=2; j<question.length; j++){
                if (diff != question[j]-question[j-1]){
                    flag = false;
                    break;
                }
            }
            result.add(flag);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ArithmeticSubarrays().checkArithmeticSubarrays(new int[] {4,6,5,9,3,7},
                new int[]{0,0,2}, new int[] {2,3,5}));
        System.out.println(new ArithmeticSubarrays().checkArithmeticSubarrays(new int[] {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10},
                new int[]{0,1,6,4,8,7}, new int[] {4,4,9,7,9,10}));
    }
}
