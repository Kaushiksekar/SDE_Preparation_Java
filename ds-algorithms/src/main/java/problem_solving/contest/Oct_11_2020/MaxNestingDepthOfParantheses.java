package problem_solving.contest.Oct_11_2020;

import java.util.*;

/* https://leetcode.com/contest/weekly-contest-210/problems/maximum-nesting-depth-of-the-parentheses/ */
public class MaxNestingDepthOfParantheses {

    public int maxDepth(String s) {

        int depth = 0;
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            if (s.charAt(i) == '('){
                depth++;
            }
            else if (s.charAt(i) == ')'){
                depth--;
            }
            else{
                if (s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '*' && s.charAt(i) != '/'){
                    map.put(s.charAt(i), depth);
                    list.add(depth);
                }
            }
        }

//        System.out.println(map);

        if (list.stream().max(Comparator.naturalOrder()).isPresent()){
            return list.stream().max(Comparator.naturalOrder()).get();
        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(new MaxNestingDepthOfParantheses().maxDepth("(1+(2*3)+((8)/4))+1"));
    }

}
