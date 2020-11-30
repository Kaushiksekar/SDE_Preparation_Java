package problem_solving.hash_tables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        int[] output = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i< numbers.length; i++){
            if (map.containsKey(target - numbers[i]) && map.get(target-numbers[i]) < i){
                output[0] = map.get(target-numbers[i])+1;
                output[1] = i+1;
                return output;
            }
            map.put(numbers[i], i);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] output = new TwoSum2().twoSum(new int[] {2,7,11,15}, 9);
        Arrays.stream(output).forEach(System.out::println);
    }

}
