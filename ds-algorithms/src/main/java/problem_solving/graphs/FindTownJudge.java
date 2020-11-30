package problem_solving.graphs;

// Problem - 997 - https://leetcode.com/problems/find-the-town-judge/

import java.util.*;

public class FindTownJudge {

    public int findJudge(int N, int[][] trust) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i=1; i<N+1; i++){
            graph.put(i, new HashSet<>());
        }
        for (int[] items: trust){
            graph.get(items[0]).add(items[1]);
        }
        Set<Integer> possibleJudges = new HashSet<>();
        for (Integer vertex: graph.keySet()){
            if (graph.get(vertex).size() == 0)
                possibleJudges.add(vertex);
        }
        for (Integer judge: possibleJudges){
            boolean isJudge = true;
            for (Integer vertex: graph.keySet()){
                if (vertex == judge){
                    continue;
                }
                if (!graph.get(vertex).contains(judge)){
                    isJudge = false;
                    break;
                }
            }
            if (isJudge)
                return judge;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindTownJudge().findJudge(2, new int[][]{{1,2}}));
        System.out.println(new FindTownJudge().findJudge(3, new int[][]{{1,3}, {2,3}}));
        System.out.println(new FindTownJudge().findJudge(3, new int[][]{{1,3}, {2,3}, {3,1}}));
        System.out.println(new FindTownJudge().findJudge(3, new int[][]{{1,2}, {2,3}}));
        System.out.println(new FindTownJudge().findJudge(4, new int[][]{{1,3}, {1,4}, {2,3}, {2,4}, {4,3}}));
    }
}
