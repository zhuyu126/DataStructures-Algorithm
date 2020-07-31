package ImplementQueueUsingStacks232;

import java.util.Stack;

public class MyQueue3 {
    private Stack<Integer> stack;
    private Stack<Integer> stack2;
    int front;
    /** Initialize your data structure here. */
    public MyQueue3() {
        stack=new Stack<>();
        stack2=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack.isEmpty()) {
            front = x;
        }
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        while (stack.size()>1){
            stack2.push(stack.pop());
        }
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!stack2.isEmpty()){
            return stack2.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty()&&stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */