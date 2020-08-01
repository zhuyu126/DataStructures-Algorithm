package ReverseLinkedList206;

public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head==null ||head.next==null){
            return head;
        }
        ListNode prev=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return prev;
    }
}
