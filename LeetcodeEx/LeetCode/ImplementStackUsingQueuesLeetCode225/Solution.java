package ImplementStackUsingQueuesLeetCode225;
/**
 *Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * One Queue Realization
 */
public class Solution {
    Queue<Integer> queue= new LinkedList<>();
    /** Initialize your data structure here. */
    public Solution() {

    }
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for(int i=1;i<queue.size();i++){
            queue.add(queue.remove());
        }
    }
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
