public class LoopQueueWithoutWastingOneCapacitySpace<E> implements Queue<E> {

    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueueWithoutWastingOneCapacitySpace(int capacity) {
        data=(E[]) new Object[capacity];
        front=0;
        tail=0;
        size=0;
    }

    public LoopQueueWithoutWastingOneCapacitySpace() {
        this(10);
    }

    public int getCapacity(){
        return data.length;
    }

    @Override
    public void enqueue(E e) {
        if (size==getCapacity()){
            //扩容
            resize(getCapacity()*2);
        }
        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;
    }
    private void resize(int newCapacity){
        E[] newDate=(E[]) new Object[newCapacity];
        for (int i=0;i<size;i++){
            newDate[i]=data[(i+front)%data.length];
        }
        data=newDate;
        front=0;
        tail=size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret=data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        if(size==getCapacity()/4&&getCapacity()/2 !=0){
            resize(getCapacity()/2);
        }
        return ret ;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }


    /**
     * 注意，我们不再使用front和tail之间的关系来判断队列是否为空，而直接使用size
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }
    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append(String.format("Queue size=%d,capacity=%d\n",size,getCapacity()));
        res.append("front[");
        for(int i=front;i!=tail;i=(i+1)%data.length){
            res.append(data[i]);
            if((i+1)%data.length!=tail){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
