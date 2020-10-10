package problem_solving.arrays;

/* Link to problem - https://leetcode.com/problems/search-insert-position/ */
public class SearchInsertedPosition {

    public int searchInsert(int[] nums, int target) {

        for (int i=0; i < nums.length; i++){
            if (nums[i] == target){
                return i;
            }
            else if (nums[i] > target){
                return i;
            }
            else if (i == nums.length-1){
                return i+1;
            }
            else{
                continue;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        int result = new SearchInsertedPosition().searchInsert(new int[]{1,3,5,6}, 7);
        System.out.println(result);
    }
}
