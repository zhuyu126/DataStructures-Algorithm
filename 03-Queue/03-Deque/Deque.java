public class Deque<E>{
    private E[] data;
    private int front, tail;
    private int size;

    public Deque (int capacity){
        data=(E[]) new Object[capacity];
        front=0;tail=0;
        size=0;
    }

    public Deque() {
        this(10);
    }
    public int getCapacity(){
        return data.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int getSize(){
        return size;
    }

    /**
     * 在队尾添加
     * addLast 的逻辑和我们之前实现的队列中的 enqueue 的逻辑是一样的
     */
    public void addLast(E e){
        if (size==getCapacity()){
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;

    }
    public void addFirst(E e){
        if (size==getCapacity()){
            resize(getCapacity()*2);
        }
        /**
         * 我们首先需要确定添加新元素的索引位置
         * 这个位置是 front - 1 的地方
         * 但是要注意，如果 front == 0，新的位置是 data.length - 1 的位置
         */
        front=front==0?data.length-1:front-1;
        data[front]=e;
        size++;
    }
    private void resize(int newCapacity){
        E[]newdata=(E[]) new Object[newCapacity];
        for (int i=0;i<size;i++){
            newdata[i]=data[(i+front)%data.length];
        }
        data=newdata;
        front=0;
        tail=size;
    }

    /**
     * removeFirst 的逻辑和我们之前实现的队列中的 dequeue 的逻辑是一样的
     * @return 删除之后队列
     */
    public E removeFirst(){
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret=data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        if (size==getCapacity()/4 && getCapacity()/2!=0){
            resize(getCapacity()/2);
        }
        return ret;
    }
    public E removeLast(){
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        /**
         * 计算删除掉队尾元素以后，新的 tail 位置
         */
        tail = tail == 0 ? data.length - 1 : tail - 1;
        E ret=data[tail];
        data[tail]=null;
        size--;
        if (size==getCapacity()/4 && getCapacity()/2!=0){
            resize(getCapacity()/2);
        }
        return ret;
    }

    public E getFirst(){
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    public E getLast(){
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        /**
         * 因为 tail 指向的是队尾元素的下一个位置，我们需要计算一下真正队尾元素的索引
         */
        int index = tail == 0 ? data.length - 1 : tail - 1;
        return data[index];
    }
    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        for(int i = 0 ; i < size ; i ++){
            res.append(data[(i + front) % data.length]);
            if(i != size - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

}
