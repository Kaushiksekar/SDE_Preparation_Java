package problem_solving.graphs;

// 797 - https://leetcode.com/problems/all-paths-from-source-to-target/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SourceTargetPath {

    private void formGraph(int[][] graph, Map<Integer, List<Integer>> graphMap){
        for (int i=0; i< graph.length; i++){
            List<Integer> list = new ArrayList<>();
            for (int item: graph[i]){
                list.add(item);
            }
            graphMap.put(i, list);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        Map<Integer, List<Integer>> graphMap = new HashMap<>();
        formGraph(graph, graphMap);
        System.out.println(graphMap);
        List<List<Integer>> dfsPaths = new ArrayList<>();
        performDfs(0, graph.length-1, graphMap, new ArrayList<>(){{add(0);}}, dfsPaths);
        return dfsPaths;
    }

    private void performDfs(int source, int destination, Map<Integer, List<Integer>> graphMap,
                            List<Integer> interList, List<List<Integer>> dfsPaths){
        if (source == destination){
            dfsPaths.add(interList);
        }
        for (Integer neighbour: graphMap.get(source)){
            List<Integer> newList = new ArrayList<>(interList);
            newList.add(neighbour);
            performDfs(neighbour, destination, graphMap, newList, dfsPaths);
        }
    }

    public static void main(String[] args) {
        System.out.println(new SourceTargetPath().allPathsSourceTarget(new int[][] {{1,2}, {3}, {3}, {}}));
        System.out.println(new SourceTargetPath().allPathsSourceTarget(new int[][] {{4,3,1}, {3,2,4}, {3}, {4}, {}}));
        System.out.println(new SourceTargetPath().allPathsSourceTarget(new int[][] {{1}, {}}));
        System.out.println(new SourceTargetPath().allPathsSourceTarget(new int[][] {{1,2,3}, {2}, {3}, {}}));
        System.out.println(new SourceTargetPath().allPathsSourceTarget(new int[][] {{1,3}, {2}, {3}, {}}));
    }
}
