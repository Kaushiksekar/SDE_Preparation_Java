package problem_solving.hash_tables;


// 217 - https://leetcode.com/problems/contains-duplicate/

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            if (!set.contains(nums[i])){
                set.add(nums[i]);
            }
            else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(new ContainsDuplicates().containsDuplicate(new int[] {1,2,3,1}));

    }

}
