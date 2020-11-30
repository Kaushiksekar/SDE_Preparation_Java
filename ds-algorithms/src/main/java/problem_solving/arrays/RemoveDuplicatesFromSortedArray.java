package problem_solving.arrays;

// 26 - https://leetcode.com/problems/remove-duplicates-from-sorted-array/

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[] {1,1,2}));

    }

    public int removeDuplicates(int[] nums) {

        Set<Integer> set= new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if (set.contains(nums[i])){
                nums[i] = -9999;
            }
            else{
                set.add(nums[i]);
            }
        }

        set.remove(-9999);
        System.out.println(set);
        return set.size();
    }

}
