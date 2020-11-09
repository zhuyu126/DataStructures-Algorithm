public class SegmentTree<E> {
    private E[] tree;
    private E[] data;

    public SegmentTree(E[] array) {
        this.data = (E[]) new Object[array.length];
        for (int i=0;i<array.length;i++){
            data[i]=array[i];
        }
        tree= (E[]) new Object[4*array.length];
    }

    public int getSize(){
        return data.length;
    }
    public E get(int index){
        if (index<0||index>=data.length){
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    /**
     * 完全二叉树的数组中该索引所表示的元素的左孩子节点的索引
     * @param index 元素索引
     * @return 该索引元素的左孩子节点索引
     */
    private int leftChild(int index){
        return 2*index+1;
    }

    /**
     * 完全二叉树的数组中该索引所表示的元素的右孩子节点的索引
     * @param index 元素索引
     * @return 该索引元素的右孩子节点索引
     */
    private int rightChild(int index){
        return 2*index+2;
    }
}
