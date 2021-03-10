package problem_solving.arrays;

// 1636

import java.util.*;

public class SortArrayByIncreasingFrequency {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Integer[] intermediateResult = map.keySet().toArray(new Integer[0]);
        Arrays.sort(intermediateResult, (o1, o2) -> {
            if (map.get(o1).compareTo(map.get(o2)) == 0){
                return o2.compareTo(o1);
            }
            return map.get(o1).compareTo(map.get(o2));
        });
        int[] result = new int[nums.length];
        int index = 0;
        int intIndex = 0;
        while (index < result.length){
            Integer item = intermediateResult[intIndex];
            intIndex++;
            for (int i=0; i<map.get(item); i++){
                result[index] = item;
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] result = new SortArrayByIncreasingFrequency().frequencySort(new int[] {1,1,2,2,2,3});
        Arrays.stream(result).forEach(System.out::println);

    }
}
