
public class LoopQueue<E> implements Queue<E> {

    private int front;
    private int tail;
    private E[] data;
    private int size;

    public LoopQueue(int capacity){
        data= (E[]) new Object[capacity+1];//有意识的增加一个空间//有意识的浪费一个空间
        front=0;
        tail=0;
        size=0;
    }
    public LoopQueue(){
        this(10);//默认大小为10
    }

    public int getCapacity(){
        return data.length-1;//因为有意识的增加一个空间用于维护，所以容量应为数组长度减一
    }

    @Override
    public void enqueue(E e) {
        if ((tail+1)%data.length==front){
            resize(getCapacity()*2);
        }
        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newdata= (E[]) new Object[newCapacity+1];
        for (int i=0;i<size;i++){
            newdata[i]=data[(i+front)%data.length];//存在front偏移量
        }
        data=newdata;
        front=0;
        tail=size;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
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

    @Override
    public boolean isEmpty() {
        return front==tail;
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
