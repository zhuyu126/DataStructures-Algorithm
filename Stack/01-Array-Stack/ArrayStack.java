public class ArrayStack<E> implements Stack<E> {

    /**
     * 基于动态数组的方式创建栈
     */
    Arrays<E>array;

    public ArrayStack(int capacity){
        array =new Arrays<>(capacity);
    }
    public ArrayStack(){
        array=new Arrays<>();
    }

    /**
     *时间复杂度O(1)
     */
    @Override
    public int geiSize() {
        return array.getSize();
    }

    /**
     *时间复杂度O(1)
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     *时间复杂度O(1)
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     *时间复杂度O(1)
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     *时间复杂度O(1)
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append("Stack");
        res.append("[");
        for(int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if(i !=array.getSize()-1){
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
