public class MaxHeap<E extends Comparable<E>> {
    private Arrays<E> arrays;

    public MaxHeap(int capacity) {
        arrays = new Arrays<>(capacity);
    }

    public MaxHeap() {
        arrays=new Arrays<>();
    }

    /**元素个数*/
    public int size(){
        return arrays.getSize();
    }

    /**判断堆中是否为空*/
    public boolean isEmpty(){
        return arrays.isEmpty();
    }

    /**从数组下标为零开始实现的堆*/

    /**
     * 完全二叉树的数组中该索引所表示的元素的父亲节点的索引
     * @param index 元素索引
     * @return 该索引元素的父亲节点索引
     */
    private int parent(int index){
        if(index==0){
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index-1)/2;
    }

    /**
     * 完全二叉树的数组中该索引所表示的元素的左孩子节点的索引
     * @param index 元素索引
     * @return 该索引元素的左孩子节点索引
     */
    private int leftChild(int index){
        return index*2+1;
    }

    /**
     * 完全二叉树的数组中该索引所表示的元素的右孩子节点的索引
     * @param index 元素索引
     * @return 该索引元素的右孩子节点索引
     */
    private int rightChild(int index){
        return index*2+2;
    }

}
