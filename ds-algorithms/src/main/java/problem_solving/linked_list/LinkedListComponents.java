package problem_solving.linked_list;

import java.util.*;

/**
 * Definition for singly-linked list.
 */
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/* https://leetcode.com/problems/linked-list-components/ */

public class LinkedListComponents {

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> map = new HashSet<>();
        for (int item: G){
            map.add(item);
        }
        ListNode current = head;
        int count = 0;
        Integer previous = null;
        while(current != null){
            if ((previous == null || !map.contains(previous)) && map.contains(current.val)){
                count++;
            }
            previous = current.val;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);
        int result = new LinkedListComponents().numComponents(head, new int[]{3,2,4});
        System.out.println(result);
    }

}
