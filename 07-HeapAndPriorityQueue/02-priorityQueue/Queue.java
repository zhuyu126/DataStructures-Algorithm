public interface Queue<E> {
    void enqueue(E e);//入队
    E dequeue();//出队
    E getFront();//队首元素
    int getSize();//队列长度
    boolean isEmpty();//队列是否为空
}
