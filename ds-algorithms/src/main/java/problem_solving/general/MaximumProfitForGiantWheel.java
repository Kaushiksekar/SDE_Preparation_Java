package problem_solving.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumProfitForGiantWheel {

    public static void main(String[] args) {
        System.out.println(new MaximumProfitForGiantWheel().
                minOperationsMaxProfit(new int[] {8,3}, 5, 6));
    }

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {

        int index = 0;
        int queueItem = 0;
        int currCounter = 0;
        int roundCounter = 0;
        int previousIndex = -1;
        List<Integer> list = new ArrayList<>();
        while(index < customers.length){
//            if (previousIndex != index){
//                queueItem += customers[index];
//                previousIndex = index;
//            }
            if (queueItem >= 4){
                currCounter += 4;
                queueItem -= 4;
            }
            else{
                queueItem += customers[index];
                currCounter = currCounter + queueItem;
                queueItem = 0;
                previousIndex = index;
                index++;
                continue;
            }
            roundCounter++;
            list.add((currCounter * boardingCost) - (roundCounter * runningCost));
        }
        int max = Collections.max(list);
        System.out.println(list);
        return list.indexOf(max)+1;
    }

}
