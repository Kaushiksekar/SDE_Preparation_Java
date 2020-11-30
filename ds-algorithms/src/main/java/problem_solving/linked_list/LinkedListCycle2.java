package problem_solving.linked_list;

// 142 - https://leetcode.com/problems/linked-list-cycle-ii/

import problem_solving.hash_tables.LinkedListCycle;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if (!set.contains(head))
                set.add(head);
            else
                return head;
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        ListNode node = new ListNode(2);
        head.next = node;
        head.next.next = new ListNode(0);
        ListNode tail = new ListNode(-4);
        head.next.next.next = tail;
        tail.next = node;

        System.out.println(new LinkedListCycle2().detectCycle(head));

    }
}
