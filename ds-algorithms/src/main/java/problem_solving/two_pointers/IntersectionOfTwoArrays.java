package problem_solving.two_pointers;

import java.util.*;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {

//        int[] result = new IntersectionOfTwoArrays().intersect(new int[] {1,2,2,1}, new int[] {2,2});
        int[] result = new IntersectionOfTwoArrays().intersect(new int[] {4,9,5}, new int[] {9,4,9,8,4});
        Arrays.stream(result).forEach(System.out::println);

    }

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i < nums1.length; i++){
            if (map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i])+1);
            }
            else{
                map.put(nums1[i], 1);
            }
        }

        for(int i=0; i < nums2.length; i++){
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                map.put(nums2[i], map.get(nums2[i])-1);
                list.add(nums2[i]);
            }
        }
        return list.stream().mapToInt(value -> value).toArray();
    }

}
