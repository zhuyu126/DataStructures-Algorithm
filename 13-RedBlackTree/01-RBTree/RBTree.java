public class RBTree<K extends Comparable<K>,V> {
    private static final boolean RED=true;
    private static final boolean BLACK=false;
    /**
     * 节点定义
     */
    private class Node{
        public K key;
        public V value;
        Node left,right;
        public boolean color;

        /**
         * 节点构造函数
         * @param key 键
         * @param value 值
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color=RED;
        }
    }
    /**根节点*/
    private Node root;

    private int size;

    public RBTree(){
        root=null;
        size=0;
    }

    /**
     * 判断节点node的颜色
     * @param node
     * @return
     */
    private boolean isRed(Node node){
        if (node==null){
            return BLACK;
        }
        return node.color;
    }

    /**
     * 左旋转
     *        node                     x
     *       /   \     左旋转         /  \
     *      T1   x   --------->   node   T3
     *          / \              /   \
     *         T2 T3            T1   T2
     * @param node
     * @return
     */
    private Node leftRotate(Node node){
        Node x=node.right;
        //左旋转
        node.right=x.left;
        x.left=node;

        x.color=node.color;
        node.color=RED;
        return x;
    }
    //颜色翻转
    private void flipColors(Node node){
        node.color=RED;
        node.left.color=BLACK;
        node.right.color=BLACK;
    }


    /**
     * 右旋转
     *          node                   x
     *         /   \     右旋转       /  \
     *        x    T2   ------->   y   node
     *       / \                       /  \
     *      y  T1                     T1  T2
     * @param node
     * @return
     */
    private Node rightRotate(Node node){
        Node x=node.left;
        //右旋转
        node.left=x.right;
        x.right=node;

        x.color=node.color;
        node.color=RED;
        return x;
    }

    /**
     * 向红黑树中添加新的元素(key, value)
     */
    public void add(K key, V value) {
        root=add(root,key,value);
        root.color=BLACK;//最终根节点为黑色节点
    }

    /**
     * 向以node为根的红黑树中插入元素(key, value)，递归算法
     * @param node 插入根的位置
     * @param key 键
     * @param value 值
     * @return 返回插入新节点后红黑树的根
     */
    private Node add(Node node,K key,V value){
        if (node==null){
            size++;
            return new Node(key,value);//默认插入红色节点
        }
        if(key.compareTo(node.key)>0){
            node.right=add(node.right,key,value);
        }else if(key.compareTo(node.key)<0){
            node.left=add(node.left,key,value);
        }else {//key.compareTo(node.key) == 0
            node.value=value;
        }
        return node;
    }

    /**
     * 最小元素所在的节点
     * 返回以node为根的二分搜索树的最小值所在的节点
     */
    private Node minimum(Node node){
        if (node.left==null){
            return node;
        }
        return minimum(node.left);
    }
    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * @param node 开始节点
     * @return 返回删除节点后新的二分搜索树的根
     */
    private Node removeMin(Node node) {
        if (node.left==null){
            //保留右子树
            Node rightNode=node.right;
            //该节点的右子树为null，则说明删除该节点
            node.right=null;
            size--;
            //返回保留的右子树
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除键为key的节点
     * @param key
     * @return
     */
    public V remove(K key) {
        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        /**
         * 删除元素比节点元素小
         */
        if (key.compareTo( node.key ) < 0) {
            node.left = remove( node.left, key );
            return node;
        }
        /**
         * 删除元素比节点元素大
         */
        else if (key.compareTo( node.key ) > 0) {
            node.right = remove( node.right, key );
            return node;
        }
        /**
         * 删除元素与节点元素相等
         */
        else {
            /**
             * 该节点左子树不存在
             */
            if (node.left == null) {
                //保留右子树
                Node right = node.right;
                //该节点的右子树为null，则说明删除该节点
                node.right = null;
                size--;
                //返回保留的右子树
                return right;
            }
            /**
             * 如果该节点右子树不存在
             */
            if (node.right == null) {
                //保留左子树
                Node left = node.left;
                //该节点左子树为null
                node.left = null;
                size--;
                return left;
            }
            /**
             * 如果该节点的左右子树都存在
             * 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
             * 用这个节点顶替待删除节点的位置
             */
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
            /**
             * 方法一：把待删除节点的右子树的最小节点的值赋值给node.e，然后最小节点为空，再返回node
             */
//            node.key = minimum( node.right ).key;
//            node.right = removeMin( node.right );
//            return node;
        }
    }

    private Node getNode(Node node,K key){
        if (node==null){
            return null;
        }
        if (key.equals(node.key)){
            return node;
        }else if (key.compareTo(node.key)>0){
            return getNode(node.right,key);
        }else {
            return getNode(node.left,key);
        }
    }

    public boolean contains(K key) {
        return getNode(root,key)!=null;
    }

    public V get(K key) {
        Node node=getNode(root,key);
        return node==null?null:node.value;
    }

    public void set(K key, V newValue) {
        Node node=getNode(root,key);
        if (node==null){
            throw new IllegalArgumentException(key+"doesn't exist!");
        }
        node.value=newValue;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }
}
