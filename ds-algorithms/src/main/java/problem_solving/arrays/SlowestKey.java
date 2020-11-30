package problem_solving.arrays;

// 1629 - https://leetcode.com/problems/slowest-key/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlowestKey {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i=0; i< releaseTimes.length; i++){
            if (i == 0){
                List<Character> list = new ArrayList<>();
                list.add(keysPressed.charAt(i));
                map.put(releaseTimes[i], list);
            }
            else{
                int diff = releaseTimes[i] - releaseTimes[i-1];
                if (map.containsKey(diff)){
                    map.get(diff).add(keysPressed.charAt(i));
                }
                else{
                    List<Character> list = new ArrayList<>();
                    list.add(keysPressed.charAt(i));
                    map.put(diff, list);
                }
            }
        }
        int maxDiff = -1;
        for (Integer duration: map.keySet()){
            if (duration > maxDiff)
                maxDiff = duration;
        }
        List<Character> resultList = map.get(maxDiff);
        resultList.sort(Character::compareTo);
        return resultList.get(resultList.size()-1);
    }

    public static void main(String[] args) {
        System.out.println(new SlowestKey().slowestKey(new int[] {9,29,49,50}, "cbcd"));
    }
}
