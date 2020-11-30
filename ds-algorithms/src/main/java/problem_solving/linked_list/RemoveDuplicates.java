package problem_solving.linked_list;

// 83 - https://leetcode.com/problems/remove-duplicates-from-sorted-list/


public class RemoveDuplicates {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode resultHead = new RemoveDuplicates().deleteDuplicates(head);
        while(resultHead != null){
            System.out.println(resultHead.val);
            resultHead = resultHead.next;
        }

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode currentReference = head;
        ListNode innerReference = currentReference;
        while(currentReference != null){
            while(innerReference.next != null && innerReference.val == innerReference.next.val){
                innerReference = innerReference.next;
            }
            currentReference.next = innerReference.next;
            currentReference = currentReference.next;
            innerReference = currentReference;
        }
        return head;
    }
}
