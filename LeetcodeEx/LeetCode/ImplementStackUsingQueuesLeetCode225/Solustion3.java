package ImplementStackUsingQueuesLeetCode225;

import java.util.LinkedList;
import java.util.Queue;

public class Solustion3 {
    Queue<Integer> queue;
    public Solustion3() {
        queue= new LinkedList<>();
    }
    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> queue2= new LinkedList<>();
        queue2.add(x);
        while (!queue.isEmpty()){
            queue2.add(queue.remove());
        }
        queue=queue2;
    }
    public int pop(){
        return queue.remove();
    }
    public int top() {
        return queue.peek();
    }
    public boolean empty() {
        return queue.isEmpty();
    }
}
