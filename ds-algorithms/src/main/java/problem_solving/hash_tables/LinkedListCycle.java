package problem_solving.hash_tables;

// 141 - https://leetcode.com/problems/linked-list-cycle/

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 */
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if (!set.contains(head))
                set.add(head);
            else
                return true;
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        ListNode node = new ListNode(2);
        head.next = node;
        head.next.next = new ListNode(0);
        ListNode tail = new ListNode(-4);
        head.next.next.next = tail;
        tail.next = node;

        System.out.println(new LinkedListCycle().hasCycle(head));

        ListNode head1 = new ListNode(1);
        System.out.println(new LinkedListCycle().hasCycle(head1));

    }

}
