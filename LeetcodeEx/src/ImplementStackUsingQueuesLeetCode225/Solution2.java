package ImplementStackUsingQueuesLeetCode225;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    Queue<Integer> queue= new LinkedList<>();
    Queue<Integer> queue2= new LinkedList<>();
    private int top;
    /** Initialize your data structure here. */
    public Solution2() {

    }
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        top=x;
    }
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queue.size()>1){
            top=queue.peek();
            queue2.add(queue.remove());
        }
        int ret=queue.remove();
        queue=queue2;
        return ret;
    }
    /** Get the top element. */
    public int top() {

        return top;
    }
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
