package problem_solving.graphs;

import java.util.*;

public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Integer> sourceCountMap = new HashMap<>();
        Map<String, Integer> destinationCountMap = new HashMap<>();
        for (List<String> ticket: tickets){
            String source = ticket.get(0);
            String destination = ticket.get(1);
            if (graph.containsKey(source)){
                List<String> list = graph.get(source);
                list.add(destination);
                Collections.sort(list);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(destination);
                graph.put(source, list);
            }
            sourceCountMap.put(source, sourceCountMap.getOrDefault(source, 0) + 1);
            destinationCountMap.put(destination, destinationCountMap.getOrDefault(destination, 0)+1);
        }
        System.out.println(sourceCountMap);
        System.out.println(destinationCountMap);
        for (String key: sourceCountMap.keySet()){
            countMap.put(key, Math.max(sourceCountMap.get(key), destinationCountMap.getOrDefault(key, 0)));
        }
        for (String key: destinationCountMap.keySet()){
            if (!countMap.containsKey(key)){
                countMap.put(key, destinationCountMap.get(key));
            }
        }
        List<String> result = new ArrayList<>();
        result.add("JFK");
        System.out.println(countMap);
        getDFS("JFK", graph, result, countMap);
        return result;
    }

    private void getDFS(String source, Map<String, List<String>> graphMap, List<String> result, Map<String, Integer> countMap) {
        if (graphMap.containsKey(source)) {
            for (String destination : graphMap.get(source)) {
                if (result.stream().filter(s -> s.equals(destination)).count() < countMap.get(destination)) {
                    result.add(destination);
                    getDFS(destination, graphMap, result, countMap);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> ticketsInput = new ArrayList<>() {{
            add(new ArrayList<>() {{add("MUC");add("LHR");}});
            add(new ArrayList<>() {{add("JFK");add("MUC");}});
            add(new ArrayList<>() {{add("SFO");add("SJC");}});
            add(new ArrayList<>() {{add("LHR");add("SFO");}});
        }};
        List<List<String>> ticketsInput2 = new ArrayList<>() {{
            add(new ArrayList<>() {{add("JFK");add("SFO");}});
            add(new ArrayList<>() {{add("JFK");add("ATL");}});
            add(new ArrayList<>() {{add("SFO");add("ATL");}});
            add(new ArrayList<>() {{add("ATL");add("JFK");}});
            add(new ArrayList<>() {{add("ATL");add("SFO");}});
        }};
        System.out.println(new ReconstructItinerary().findItinerary(ticketsInput));
        System.out.println(new ReconstructItinerary().findItinerary(ticketsInput2));
    }
}
