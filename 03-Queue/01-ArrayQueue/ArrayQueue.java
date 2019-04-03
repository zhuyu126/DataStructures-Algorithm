public class ArrayQueue<E> implements Queue<E> {
    /**
     * 基于动态数组实现队列
     */
    private Arrays<E>arrays;

    public ArrayQueue(int capacity){
        arrays=new Arrays<>(capacity);
    }
    public ArrayQueue(){
        arrays=new Arrays<>();
    }


    @Override
    public void enqueue(E e) {
        arrays.addLast(e);
    }

    /**
     * 时间复杂度为O(n)
     * @return
     */
    @Override
    public E dequeue() {
        return arrays.removeFirst();
    }

    @Override
    public E getFront() {
        return arrays.getFirst();
    }

    @Override
    public int getSize() {
        return arrays.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arrays.isEmpty();
    }

    /**
     * 得到队列容积
     * @return
     */
    public int getCapacity(){
        return arrays.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append("Queue:");
        res.append("front [");
        for(int i=0;i<arrays.getSize();i++){
            res.append(arrays.get(i));
            if(i!=arrays.getSize()-1){
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

}
