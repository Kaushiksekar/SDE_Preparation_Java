package problem_solving.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution3{

    public static void main(String[] args) {

        System.out.println(new Solution3().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution3().lengthOfLongestSubstring("a"));

    }

    public int lengthOfLongestSubstring(String input) {
        if (input.length() == 0){
            return 0;
        }
        List<String> list = new ArrayList<>();
        String stateStore = input.substring(0,1);
        for (char item: input.substring(1).toCharArray()){
            if (stateStore.contains(String.valueOf(item))){
                list.add(stateStore);
                stateStore = String.valueOf(item);
            }
            else{
                stateStore = stateStore.concat(String.valueOf(item));
                if (list.contains(stateStore)){
                    list.add(stateStore.substring(0, stateStore.length()-1));
                    stateStore = String.valueOf(stateStore.charAt(stateStore.length()-1));
                }
            }
        }
        if (stateStore.length() > 0){
            list.add(stateStore);
        }
        return String.valueOf(Collections.max(list, Comparator.comparing(String::length))).length();
    }

}