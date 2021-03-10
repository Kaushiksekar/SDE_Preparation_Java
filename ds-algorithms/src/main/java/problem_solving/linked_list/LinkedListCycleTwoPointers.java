package problem_solving.linked_list;

public class LinkedListCycleTwoPointers {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node = new ListNode(2);
        head.next = node;
        head.next.next = new ListNode(0);
        ListNode tail = new ListNode(-4);
        head.next.next.next = tail;
        tail.next = node;

        System.out.println(new LinkedListCycleTwoPointers().detectCycle(head));
    }

    private boolean detectCycle(ListNode head) {

        if (head == null){
            return false;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head.next;

        while (slowPointer != fastPointer){
            if (fastPointer == null || fastPointer.next == null){
                return false;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return true;

    }
}
