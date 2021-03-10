package problem_solving.arrays;

// 763 - https://leetcode.com/problems/partition-labels/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {

        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<S.length(); i++){
            map.put(S.charAt(i), i);
        }

        int possibleSplit = 0;
        boolean isRunnable = true;
        int startPosition = 0;

        for (int pointer=0; pointer<S.length(); pointer++){
            int lastOccurance = map.get(S.charAt(pointer));
            if (isRunnable){
                startPosition = pointer;
                possibleSplit = lastOccurance;
                isRunnable = false;
            }
            else{
                if (lastOccurance < possibleSplit){
                    continue;
                }
                else{
                    possibleSplit = lastOccurance;
                }
            }
            if (pointer == possibleSplit){
                result.add((possibleSplit+1) - startPosition);
                isRunnable = true;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
