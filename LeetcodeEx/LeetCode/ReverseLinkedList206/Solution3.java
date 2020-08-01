package ReverseLinkedList206;

public class Solution3 {
    public ListNode reverseList(ListNode head){
        return reverseList(null,head);
    }

    private ListNode reverseList(ListNode prev,ListNode node){
        if (node==null){
            return prev;
        }
        ListNode next=node.next;
        node.next=prev;
        return reverseList(node,next);
    }
}
