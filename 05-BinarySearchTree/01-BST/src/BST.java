/**
 * 二叉树具有天然的递归结构
 *    每个节点的左子树也是二叉树
 *    每个节点的右子树也是二叉树
 * 二叉树不一定是"满"的
 *    一个节点也可以是二叉树
 *    空也是二叉树
 *
 * 二分搜索树是二叉树
 * 二分搜索树的每个节点值：
 *    大于其左子树的所有节点的值
 *    小于其右子树的所有节点的值
 * 每一颗子树也是二分搜索树
 * 存储元素必须具有可比较性（栈队列链表不具该性质）
 * 二分搜索树不包含重复元素
 */
public class BST<E extends Comparable<E>> {
    /**
     * 节点定义
     */
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }
    /**根节点*/
    private Node root;
    /**元素存储个数*/
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    /**
     * 得到存储元素的个数即大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断二分搜索树是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**添加新元素e*/
    public void add(E e){
        root=add(root,e);
    }

    /**
     * 在根节点为node的二叉树添加新元素e 递归算法
     * @param node 节点
     * @param e 插入元素
     * @return 插入的新节点的二分搜索树的根
     */

    private Node add(Node node,E e){
        if(node==null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)>0){
            node.right=add(node.right,e);
        }else if (e.compareTo(node.e)<0){
            node.left=add(node.left,e);
        }
        return node;
    }

    /**
     * 二叉树中是否含有元素E
     * @param e 查找元素
     * @return
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    /**
     * 以node为根节点查找是否含有元素e 递归实现
     * @param node 节点
     * @param e 查找元素
     * @return true/false
     */
    private boolean contains(Node node,E e){
        if(node==null){
            return false;
        }
        if(e.compareTo(node.e)>0){
            return contains(node.right,e);
        }else if (e.compareTo( node.e)<0){
            return contains(node.left,e);
        }
        return true;
    }

}
