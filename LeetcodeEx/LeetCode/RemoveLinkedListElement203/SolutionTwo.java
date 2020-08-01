package RemoveLinkedListElement203; /**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */

class SolutionTwo {
    public ListNode removeElements(ListNode head, int val) {
        /*
        使用虚拟头节点解决
         */
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;

        ListNode prev=dummyHead;
        while(prev.next!=null){
            if(prev.next.val==val){
                prev.next=prev.next.next;
            }else {
                prev=prev.next;
            }
        }
        return dummyHead.next;
    }
}

