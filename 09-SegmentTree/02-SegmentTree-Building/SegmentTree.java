public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] array,Merger<E> merger) {
        this.merger=merger;
        this.data = (E[]) new Object[array.length];
        for (int i=0;i<array.length;i++){
            data[i]=array[i];
        }
        tree= (E[]) new Object[4*array.length];
        buildSegmentTree(0,0,data.length-1);
    }

    /**
     * 在 treeRoot 的位置创建表示区间[l...r]的线段树 递归实现
     * @param treeIndex 创建线段树的根节点
     * @param l 左区间起始点
     * @param r 右区间终止点
     */
    private void buildSegmentTree(int treeIndex,int l,int r) {
        if (l==r){
            tree[treeIndex]=data[l];
            return;
        }
        int leftTreeIndex=leftChild(treeIndex);
        int rightTreeIndex=rightChild(treeIndex);

        int mid=l+(r-l)/2;
        buildSegmentTree(leftTreeIndex,l,mid);
        buildSegmentTree(rightTreeIndex,mid+1,r);

        tree[treeIndex]=merger.merger(tree[leftTreeIndex],tree[rightTreeIndex]);
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

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append("[");
        for (int i=0;i<tree.length;i++){
            if (tree[i]!=null){
                res.append(tree[i]);
            }else {
                res.append("null");
            }
            if (i!=tree.length-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}
