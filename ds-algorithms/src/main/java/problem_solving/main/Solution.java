package problem_solving.main;

import java.util.Map;
import java.util.HashMap;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else{
                map.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> mapEntry: map.entrySet()){
            if (mapEntry.getValue() == 1){
                return mapEntry.getKey();
            }
        }
        return -1;
    }
}