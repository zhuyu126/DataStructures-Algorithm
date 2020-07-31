package RemoveLinkedListElement; /**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        /*
        不使用虚拟头节点解决
         */
        while(head !=null && head.val==val){
            //ListNode delNode=head;
            head = head.next;
            //delNode.next=null;
        }
        if(head==null){
            return null;
        }
        ListNode prev=head;
        while(prev.next!=null){
            if(prev.next.val==val){
//                ListNode delNode=prev.next;
//                prev.next=delNode.next;
//                delNode.next=null;
                prev.next=prev.next.next;
            }else {
                prev=prev.next;
            }
        }
        return head;
    }
}

