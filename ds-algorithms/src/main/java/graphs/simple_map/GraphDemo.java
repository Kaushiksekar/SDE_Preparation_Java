package graphs.simple_map;

import java.util.*;

class Graph{

    private Map<Integer, List<Integer>> graphMap;
    private int graphSize;

    public Graph() {
        graphMap = new HashMap<>();
        graphSize = 0;
    }

    public void addVertex(Integer value){
        if (graphMap.containsKey(value)){
            throw new RuntimeException("Cannot contain duplicate values");
        }
        else{
            graphMap.put(value, new ArrayList<>());
            graphSize += 1;
        }
    }

    public boolean isVertexPresent(Integer value){
        return graphMap.containsKey(value);
    }

    public void addEdge(Integer vertex1, Integer vertex2){
        if (!graphMap.containsKey(vertex1))
            graphMap.put(vertex1, new ArrayList<>());
        else if (!graphMap.containsKey(vertex2))
            graphMap.put(vertex2, new ArrayList<>());
        graphMap.get(vertex1).add(vertex2);
    }

    public Integer getGraphSize(){
        return graphSize;
    }

    public List<Integer> getNeighbours(Integer value){
        if (!graphMap.containsKey(value))
            throw new RuntimeException("Vertex does not exist");
        else
            return graphMap.get(value);
    }

    public Map<Integer, List<Integer>> getGraphItems() {
        return graphMap;
    }

    public List<Integer> getDFS(){
        List<Integer> list = new ArrayList<>();
        for (Integer key: graphMap.keySet()){
            getDFS(key, list);
        }
        return list;
    }

    private void getDFS(Integer key, List<Integer> list){
        if (!list.contains(key)){
            list.add(key);
            for (Integer vertex: graphMap.get(key)){
                getDFS(vertex, list);
            }
        }
    }

    public List<Integer> getBFS(){
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (Integer value: graphMap.keySet()){
            getBFS(value, list, queue);
        }
        return list;
    }

    private void getBFS(Integer value, List<Integer>list, Queue<Integer> queue){
        if (!list.contains(value))
            list.add(value);
        for (Integer value1: graphMap.get(value)){
            if (!list.contains(value1)){
                list.add(value1);
                queue.add(value1);
            }
        }
        if (queue.size() > 0)
            getBFS(queue.poll(), list, queue);
    }


}

public class GraphDemo {

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(1, 4);
        graph.addEdge(1, 3);
        graph.addEdge(2, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 2);
        System.out.println(graph.getGraphItems());
        System.out.println("Size of the graph: " + graph.getGraphSize());
        System.out.println("DFS : " + graph.getDFS());
        System.out.println("BFS : " + graph.getBFS());
    }
}
