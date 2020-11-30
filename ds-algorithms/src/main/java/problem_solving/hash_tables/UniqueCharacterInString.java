package problem_solving.hash_tables;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharacterInString {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), Integer.MAX_VALUE);
            }
            else{
                map.put(s.charAt(i), i);
            }
        }
        int minValue = Integer.MAX_VALUE;
        for (Character key: map.keySet()){
            if (map.get(key) < minValue) {
                minValue = map.get(key);
            }
        }
        if (minValue == Integer.MAX_VALUE){
            return -1;
        }
        return minValue;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueCharacterInString().firstUniqChar("leetcode"));
        System.out.println(new UniqueCharacterInString().firstUniqChar("loveleetcode"));
        System.out.println(new UniqueCharacterInString().firstUniqChar("cc"));
    }

}
