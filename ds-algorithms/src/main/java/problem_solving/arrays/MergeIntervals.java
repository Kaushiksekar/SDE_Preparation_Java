package problem_solving.arrays;

// 56 - https://leetcode.com/problems/merge-intervals/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
//        int [][] result = new MergeIntervals().merge(new int[][] {{1,3}, {2,6}, {8,10}, {15,18}});
        int [][] result = new MergeIntervals().merge(new int[][] {{1,4}, {0,4}});
        Arrays.stream(result).forEach(ints -> {
            for (int i: ints){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        });
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1)
            return intervals;
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        List<int[]> intermediateResult = new ArrayList<>(Arrays.asList(intervals));

        for (int i=0; i<intermediateResult.size()-1; i++){
            if (intermediateResult.get(i+1)[0] >= intermediateResult.get(i)[0] &&
                    intermediateResult.get(i+1)[0] <= intermediateResult.get(i)[1]){
                if (intermediateResult.get(i+1)[1] > intermediateResult.get(i)[1]){
                    intermediateResult.get(i)[1] = intermediateResult.get(i+1)[1];
                }
                intermediateResult.remove(i+1);
                i--;
            }
        }
        return intermediateResult.toArray(new int[][]{});
    }

}
