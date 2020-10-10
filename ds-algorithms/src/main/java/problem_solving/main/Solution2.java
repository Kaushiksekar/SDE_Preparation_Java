package problem_solving.main;

import java.lang.reflect.Array;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {

//        System.out.println(new Solution2().maxPoints(new int[][]{{1,1},{2,2},{3,3}}));
//        System.out.println(new Solution2().maxPoints(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}));
        System.out.println(new Solution2().maxPoints(new int[][]{{1,1},{2,1},{2,2},{1,4},{3,3}}));

    }

    public int maxPoints(int[][] points) {

        Map<Double, List<int[]>> output = new HashMap<>();

        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                double hashValue = calculateHashValue(points[i], points[j]);
                if (output.containsKey(hashValue)){

                    int finalI = i;
                    if (!output.get(hashValue).stream().anyMatch(ints -> Arrays.equals(ints, points[finalI]))){
                        output.get(hashValue).add(points[i]);
                    }

                    int finalJ = j;
                    if (!output.get(hashValue).stream().anyMatch(ints -> Arrays.equals(ints, points[finalJ]))){
                        output.get(hashValue).add(points[j]);
                    }

//                    if (!output.get(hashValue).contains(points[i])){
//                        output.get(hashValue).add(points[i]);
//                    }
//                    if (!output.get(hashValue).contains(points[j])){
//                        output.get(hashValue).add(points[j]);
//                    }
                }
                else{
                    List<int[]> value = new ArrayList<>();
                    value.add(points[i]);
                    value.add(points[j]);
                    output.put(hashValue, value);
                }
            }
        }

        System.out.println(output);

        int maxValue = 1;

        for (Map.Entry<Double, List<int[]>> pair: output.entrySet()){
            if (pair.getValue().size() > maxValue){
                maxValue = pair.getValue().size();
            }
        }
        return maxValue;

    }

    public double calculateHashValue(int[] pair1, int[] pair2){
        if (pair2[0] == pair1[0]){
            return (float) -999.99;
        }
        return ((double)(pair2[1] - pair1[1])) / ((double)(pair2[0] - pair1[0]));
    }



}
