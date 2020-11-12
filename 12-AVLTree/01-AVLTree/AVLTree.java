import java.util.ArrayList;

/**
 * 基于映射实现的BST实现AVLTree
 * @param <K>
 * @param <V>
 */
public class AVLTree<K extends Comparable<K>,V>{

    /**
     * 节点定义
     */
    private class Node{
        public K key;
        public V value;
        Node left,right;
        public int height;

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
            this.height=1;
        }
    }
    /**根节点*/
    private Node root;

    private int size;

    public AVLTree(){
        root=null;
        size=0;
    }

    /**
     * 获得节点node的高度
     * @param node
     * @return
     */
    private int getHeight(Node node){
        if (node==null){
            return 0;
        }
        return node.height;
    }

    /**
     * 向二分搜索树中添加新的元素(key, value)
     */
    public void add(K key, V value) {
        root=add(root,key,value);
    }

    /**
     * 向以node为根的二分搜索树中插入元素(key, value)，递归算法
     * @param node 插入根的位置
     * @param key 键
     * @param value 值
     * @return 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node,K key,V value){
        if (node==null){
            size++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key)>0){
            node.right=add(node.right,key,value);
        }else if(key.compareTo(node.key)<0){
            node.left=add(node.left,key,value);
        }else {
            node.value=value;
        }
        //更新height
        node.height=1+Math.max(getHeight(node.left),getHeight(node.right));
        //计算平衡因子
        int balanceFactor=getBalanceFactor(node);
//        if (Math.abs(balanceFactor)>1){
//            System.out.println("unbalanced,The balanceFactor is:"+balanceFactor);
//        }

        /**
         * 维护平衡
         */
        //LL
        if (balanceFactor>1&&getBalanceFactor(node.left)>=0){
            return rightRotate(node);
        }
        //RR
        if (balanceFactor<-1&& getBalanceFactor(node.right)<=0){
            return leftRotate(node);
        }
        //LR
        if (balanceFactor>1&&getBalanceFactor(node.left)<0){
            node.left=leftRotate(node.left);
            //LL
            return rightRotate(node);
        }
        //RL
        if (balanceFactor<-1&&getBalanceFactor(node.right)>0){
            node.right=rightRotate(node.right);
            //RR
            return leftRotate(node);
        }
        return node;
    }

    /**
     * 对节点y进行向右旋转操作，返回旋转后新的根节点x
     *              y                              x
     *            / \                           /   \
     *           x   T4     向右旋转 (y)        z     y
     *          / \       - - - - - - - ->    / \   / \
     *         z   T3                       T1  T2 T3 T4
     *        / \
     *      T1   T2
     * @param y
     * @return
     */
    private Node rightRotate(Node y){
        Node x=y.left;
        Node T3=x.right;
        //右旋转过程
        x.right=y;
        y.left=T3;
        //更新height
        y.height=Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height=Math.max(getHeight(x.left),getHeight(x.right))+1;
        return x;
    }

    /**
     * 对节点y进行向左旋转操作，返回旋转后新的根节点x
     *         y                             x
     *       /  \                          /   \
     *      T1   x      向左旋转 (y)       y     z
     *          / \   - - - - - - - ->   / \   / \
     *        T2  z                     T1 T2 T3 T4
     *           / \
     *          T3 T4
     * @param y
     * @return
     */
    private Node leftRotate(Node y){
        Node x=y.right;
        Node T2=x.left;
        //左旋过程
        x.left=y;
        y.right=T2;
        //更新height
        y.height=Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height=Math.max(getHeight(x.left),getHeight(x.right))+1;
        return x;
    }

    /**
     * 获得节点node的平衡因子
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node){
        if (node==null){
            return 0;
        }
        return getHeight(node.left)-getHeight(node.right);
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
             * 方法二：把待删除节点的右子树的最小节点的值赋值给node.e，然后最小节点为空，再返回node
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

    /**
     * 判断该树是不是BST二分搜索树
     * 二分搜索树 中序遍历升序排列
     * @return
     */
    public boolean isBST(){
        ArrayList<K> keys=new ArrayList<>();
        inOrder(root,keys);
        for (int i=1;i<keys.size();i++){
            if (keys.get(i-1).compareTo(keys.get(i))>0){
                return false;
            }
        }
        return true;
    }

    /**
     * 中序遍历
     * @param node
     * @param keys
     */
    private void inOrder(Node node, ArrayList<K> keys){
        if (node==null){
            return;
        }
        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys);
    }

    /**
     * 判断该二叉树是否是一棵平衡二叉树
     * @return
     */
    public boolean isBalanced(){
        return isBalanced(root);
    }

    /**
     * 判断以Node为根的二叉树是否是一棵平衡二叉树，递归算法
     * @param node
     * @return
     */
    private boolean isBalanced(Node node){
        if (node==null){
            return true;
        }
        int balanceFactor=getBalanceFactor(node);
        if (Math.abs(balanceFactor)>1){
            return false;
        }
        return isBalanced(node.left)&&isBalanced(node.right);
    }
}
