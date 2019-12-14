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
//    /**添加新元素e*/
//    public void add(E e){
//        if(root==null){
//            root=new Node(e);
//            size++;
//        }
//        else {
//            add(root,e);
//        }
//    }
//
//    /**
//     * 在根节点为node的二叉树添加新元素e 递归算法
//     */
//    private void add(Node node,E e){
//        if(node.e.equals(e)){
//            return;
//        }
//        if (e.compareTo(node.e)>0&&node.right==null){
//            node.right=new Node(e);
//            size++;
//            return;
//        }else if(e.compareTo(node.e)<0&&node.left==null){
//            node.left=new Node(e);
//            size++;
//            return;
//        }else if(e.compareTo(node.e)>0){
//            add(node.right,e);
//        }else if (e.compareTo(node.e)<0){
//            add(node.left,e);
//        }
//
//    }

    /**
     * 改进方法
     */
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

}
