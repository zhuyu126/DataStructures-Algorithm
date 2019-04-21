/**
 * 对于数组实现，仅仅在数组末尾进行插入和删除操作，开销为O（1），而在数组下标0处插入和删除开销为O（n）。
 * 相反的是，对于链表，在链表头插入和删除元素，开销为O（1），链表尾插入删除开销则为O（n）。
 * 若链表维护一个尾节点，则在链表尾插入新元素的开销也可以下降至O(1)。
 * @param <E>
 */
public class LinkedListStack<E>implements Stack<E> {

    private LinkedList<E>list;
    public LinkedListStack(){
        list=new LinkedList<>();
    }
    @Override
    public int geiSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append("Stack:top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack=new LinkedListStack<>();
        for(int i=0;i<5;i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
