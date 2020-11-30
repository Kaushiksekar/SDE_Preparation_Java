package problem_solving.backtracking;

// https://leetcode.com/problems/binary-watch/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryWatch {

    private static final int TOTAL_POS = 10;
    private static final int HOUR_POS = 4;
    private List<String> result = new ArrayList<>();

    public List<String> readBinaryWatch(int num){
        backTracking(num, 0, 0, 0);
        return result;
    }

    private void backTracking(int num, int pos, int hour, int min){
         if (hour > 11 || min > 59)
            return;
        else if (num == 0){
            if (min < 10){
                result.add(hour + ":0" + min);
            }
            else{
                result.add(hour + ":" + min);
            }
            return;
        }
        for (int i=pos; i<TOTAL_POS; i++){
            if (i < HOUR_POS)
                backTracking(num-1, i+1, (int) (hour + Math.pow(2, i)), min);
            else
                 backTracking(num-1, i+1, hour, (int) (min + Math.pow(2, i - HOUR_POS)));
        }
    }

    public static void main(String[] args) {

        new BinaryWatch().readBinaryWatch(2).forEach(System.out::println);

    }
}
