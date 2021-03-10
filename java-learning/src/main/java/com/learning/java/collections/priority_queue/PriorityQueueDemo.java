package com.learning.java.collections.priority_queue;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(3);
        queue.add(4);
        queue.add(5);
        queue.add(8);
        queue.add(2);

        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

    }
}
