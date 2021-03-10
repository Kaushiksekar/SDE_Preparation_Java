package problem_solving.heaps;

// 703 - https://leetcode.com/problems/kth-largest-element-in-a-stream/

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> priorityQueue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.priorityQueue = new PriorityQueue<>(k);
        for (int item: nums){
            priorityQueue.add(item);
        }
        int i = nums.length;
        while (i > k){
            priorityQueue.poll();
            i = i - 1;
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < k){
            priorityQueue.add(val);
        }
        else if (val > priorityQueue.peek()){
            priorityQueue.add(val);
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }
}
