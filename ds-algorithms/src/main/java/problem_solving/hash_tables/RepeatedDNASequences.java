package problem_solving.hash_tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* link - https://leetcode.com/problems/repeated-dna-sequences/ */
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {

        List<String> result = new ArrayList<>();
        Map<String, Integer> trackerHashMap = new HashMap<>();

        if (s.length() < 10){
            return result;
        }

        trackerHashMap.put(s.substring(0, 10), 1);

        for (int i=1; i<s.length(); i++){
            if (i+10 <= s.length()){
                if (trackerHashMap.containsKey(s.substring(i, i+10))){
                    trackerHashMap.put(s.substring(i, i+10), trackerHashMap.get(s.substring(i, i+10)) + 1);
                    if (!result.contains(s.substring(i, i+10))){
                        result.add(s.substring(i, i+10));
                    }
                }
                else{
                    trackerHashMap.put(s.substring(i, i+10), 1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<String> result = new RepeatedDNASequences().findRepeatedDnaSequences("AAAAAAAAAAAA");
        System.out.println(result);

    }

}
