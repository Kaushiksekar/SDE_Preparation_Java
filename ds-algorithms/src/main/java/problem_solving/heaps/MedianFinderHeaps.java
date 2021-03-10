package problem_solving.heaps;

// 295 - https://leetcode.com/problems/find-median-from-data-stream/
// Heaps - two heaps - min heap and max heap

import java.util.PriorityQueue;

public class MedianFinderHeaps {

    PriorityQueue<Integer> lowPriorityQueue;
    PriorityQueue<Integer> highPriorityQueue;

    public MedianFinderHeaps() {
        lowPriorityQueue = new PriorityQueue<>((a,b)->b-a);
        highPriorityQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        lowPriorityQueue.add(num);
        highPriorityQueue.add(lowPriorityQueue.poll());
        if (lowPriorityQueue.size() < highPriorityQueue.size()){
            lowPriorityQueue.add(highPriorityQueue.poll());
        }
    }

    public double findMedian() {
        if (lowPriorityQueue.size() > highPriorityQueue.size())
            return lowPriorityQueue.peek();
        return (lowPriorityQueue.peek() + highPriorityQueue.peek()) * 0.5;
    }

    public static void main(String[] args) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> b-a);
//        priorityQueue.add(9);
//        priorityQueue.add(3);
//        priorityQueue.add(4);
//        priorityQueue.add(7);
//        System.out.println(priorityQueue);

        MedianFinderHeaps obj = new MedianFinderHeaps();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}
