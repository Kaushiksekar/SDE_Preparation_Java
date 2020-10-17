package problem_solving.hash_tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// problem number 299 -> https://leetcode.com/problems/bulls-and-cows/
public class BullsAndCows {

    public static void main(String[] args) {

//        System.out.println(new BullsAndCows().getHint("1807", "7810"));
//        System.out.println(new BullsAndCows().getHint("1123", "0111"));
//        System.out.println(new BullsAndCows().getHint("1", "0"));
//        System.out.println(new BullsAndCows().getHint("1", "1"));
        System.out.println(new BullsAndCows().getHint("11", "10"));

    }

    public String getHint(String secret, String guess) {

        Map<Character, List<Integer>> fieldIndexMap = new HashMap<>();
        int bullCounter = 0;
        int crowCounter = 0;

        for (int i=0; i<secret.length(); i++){

            if (secret.charAt(i) == guess.charAt(i)){
                bullCounter += 1;
                guess = guess.substring(0,i) + "#" + guess.substring(i+1);
                continue;
            }
            if (fieldIndexMap.containsKey(secret.charAt(i))){
                fieldIndexMap.get(secret.charAt(i)).add(i);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                fieldIndexMap.put(secret.charAt(i), list);
            }
        }

        for(int i=0; i<guess.length(); i++){
            if (fieldIndexMap.containsKey(guess.charAt(i))) {
                if (!fieldIndexMap.get(guess.charAt(i)).contains(i) && fieldIndexMap.get(guess.charAt(i)).size()>0) {
                    crowCounter += 1;
                    fieldIndexMap.get(guess.charAt(i)).remove(0);
                }
            }
        }
        return bullCounter + "A" + crowCounter + "B";
    }

}
