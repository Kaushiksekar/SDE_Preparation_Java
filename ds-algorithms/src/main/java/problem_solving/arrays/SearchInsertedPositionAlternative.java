package problem_solving.arrays;

import java.util.Arrays;

public class SearchInsertedPositionAlternative {
    public int searchInsert(int[] nums, int target) {

        int resultIndex = 0;

        resultIndex = binarySearch(nums, target, 0);

        return resultIndex;

    }

    public int binarySearch(int[] nums, int target, int indexToAdd){
        if (nums[nums.length / 2] == target){
            return nums.length/2 + indexToAdd;
        }
        else{
            if (nums.length > 1 && target < nums[nums.length/2]){
                return binarySearch(Arrays.copyOfRange(nums, 0, nums.length/2), target, indexToAdd);
            }
            else if (nums.length == 1 && target < nums[nums.length/2]){
                return indexToAdd;
            }
            else if(nums.length > 1 && target > nums[nums.length/2]){
                return binarySearch(Arrays.copyOfRange(nums, nums.length/2, nums.length), target, nums.length/2 + indexToAdd);
            }
            else if (nums.length == 1 && target > nums[nums.length/2]){
                return indexToAdd + 1;
            }
            else{
                System.out.println("Not found");
                return -9999;
            }
        }
    }

    public static void main(String[] args) {
        int result = new SearchInsertedPositionAlternative().searchInsert(new int[]{1,3,5}, 4);
        System.out.println(result);
    }
}
