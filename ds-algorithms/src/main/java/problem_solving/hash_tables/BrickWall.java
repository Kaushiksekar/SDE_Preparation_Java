package problem_solving.hash_tables;

// 554 - https://leetcode.com/problems/brick-wall/

import java.util.*;

public class BrickWall {

    public void hello(){

    }

    public int hello(int a){
        return 1;
    }

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> sumCounter = new HashMap<>();
        for (int i=0; i<wall.size(); i++){
            int sum = 0;
            for (int j=0; j<wall.get(i).size()-1; j++){
                sum += wall.get(i).get(j);
                if (sumCounter.containsKey(sum)){
                    sumCounter.put(sum, sumCounter.get(sum)+1);
                }
                else{
                    sumCounter.put(sum, 1);
                }
            }
        }
        int maxValue = 0;
        if (sumCounter.values().stream().max(Comparator.naturalOrder()).isPresent()){
            maxValue = sumCounter.values().stream().max(Comparator.naturalOrder()).get();
        }
        return wall.size()-maxValue;
    }

    public static void main(String[] args) {
        List<Integer> innerList1 = new ArrayList<>(); innerList1.add(1); innerList1.add(2); innerList1.add(2); innerList1.add(1);
        List<Integer> innerList2 = new ArrayList<>(); innerList2.add(3); innerList2.add(1); innerList2.add(2);
        List<Integer> innerList3 = new ArrayList<>(); innerList3.add(1); innerList3.add(3); innerList3.add(2);
        List<Integer> innerList4 = new ArrayList<>(); innerList4.add(2); innerList4.add(4);
        List<Integer> innerList5 = new ArrayList<>(); innerList5.add(3); innerList5.add(1); innerList5.add(2);
        List<Integer> innerList6 = new ArrayList<>(); innerList6.add(1); innerList6.add(3); innerList6.add(1); innerList6.add(1);
        List<List<Integer>> list = new ArrayList<>();
        list.add(innerList1); list.add(innerList2);list.add(innerList3);list.add(innerList4);list.add(innerList5);list.add(innerList6);
        System.out.println(new BrickWall().leastBricks(list));
    }
}
