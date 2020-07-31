package RemoveLinkedListElement; /**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */

class SolutionThree {
    public ListNode removeElements(ListNode head, int val) {
       /*
       使用递归方式求解
        */
       if(head==null){
           return null;
       }
       //ListNode result=removeElements(head.next,val);
//       if(head.val==val){
//           return head.next;
//       }
//       else {
//           return head;
//       }
        head.next=removeElements(head.next,val);
        return head.val==val ?head.next:head;
    }
}

