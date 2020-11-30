package problem_solving.arrays;

// 14 - https://leetcode.com/problems/longest-common-prefix/

import java.util.*;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[] {"dog","racecar","car"}));

    }

    public String longestCommonPrefix(String[] strs) {

        Map<String, List<Integer>> map = new HashMap<>();
        String longestPrefix = "";

        for (int arrayIndex=0; arrayIndex<strs.length; arrayIndex++){
            String previousString = "";
            for (int i=0; i<strs[arrayIndex].length(); i++){
                previousString = previousString + strs[arrayIndex].charAt(i);
                List<Integer> list;
                if (map.containsKey(previousString)){
                    list = map.get(previousString);
                }
                else{
                    list = new ArrayList<>();
                }
                list.add(arrayIndex);
                map.put(previousString, list);
                if (list.size() == strs.length){
                    if (previousString.length() > longestPrefix.length()){
                        longestPrefix = previousString;
                    }
                }
            }
        }
        return longestPrefix;

    }

}
