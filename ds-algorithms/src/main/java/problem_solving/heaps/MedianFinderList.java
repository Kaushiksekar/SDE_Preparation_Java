package problem_solving.heaps;

// 295 - https://leetcode.com/problems/find-median-from-data-stream/
// List - Binary Search - insertion sort implementation

import java.util.ArrayList;
import java.util.List;

public class MedianFinderList {

    List<Integer> list;

    /** initialize your data structure here. */
    public MedianFinderList() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        int index = binarySearch(num);
        list.add(index, num);
        System.out.println(list);
    }

    public int binarySearch(int num){
        int left = 0;
        int right = list.size()-1;
        while(left <= right){
            int middle = (left + right) / 2;
            if (list.get(middle) == num){
                left = middle;
                break;
            }
            if (list.get(middle) < num)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return left;
    }

    public double findMedian() {
        if (list.size() % 2 != 0)
            return list.get(list.size()/2);
        else if (list.size() == 0)
            return 0.0;
        else
            return ((double) list.get(list.size()/2) + (double) list.get((list.size()/2) - 1)) / 2;
    }

    public static void main(String[] args) {
        MedianFinderList obj = new MedianFinderList();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}
