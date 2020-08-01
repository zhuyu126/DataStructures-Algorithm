import javafx.util.Pair;

public class LinkedListRecursion<E> {
    /**
     * 节点类
     */
    private class Node {
        public E e;
        public Node next;

        public Node(E e, LinkedListRecursion.Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedListRecursion() {
        head=null;
        size=0;
    }

    /**
     * 获取链表中元素个数
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     * @return boolean
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 在链表index(0-based)位置添加新元素e
     * @param index 类似数组索引
     * @param e 插入元素
     */
    public void add(int index, E e){
        if (index<0||index>size){
            throw new IllegalArgumentException("Add failed,Illegal index");
        }
        head=add(head,index,e);
        size++;
    }

    /**
     * 在以node为头结点的链表的index位置插入元素e，递归算法
     * @param node 节点
     * @param index 类似数组索引
     * @param e 插入元素
     * @return node节点
     */
    private Node add(Node node,int index,E e){
        if (index==0){
            return new Node(e,node);
        }
        node.next=add(node.next,index-1,e);
        return node;
    }

    /**
     * 在链表头添加新元素
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在链表末尾添加元素e
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获得链表的第index(0-based)个位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if (index<0||index>=size){
            throw new IllegalArgumentException("Add failed,Illegal index");
        }
        return get(head,index);
    }

    /**
     * 在以node为头结点的链表中，找到第index个元素，递归算法
     * @param node
     * @param index
     * @return
     */
    private E get(Node node,int index){
        if (index==0){
            return node.e;
        }
        return get(node.next,index-1);
    }

    /**
     * 获取第一个节点 头节点
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取最后一个节点 尾部节点
     * @return
     */
    public E getLast(){
        return get(size-1);
    }

    /**
     * 修改链表的第index(0-based)个位置的元素为e
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Update failed,Illegal index");
        }
        set(head,index,e);
    }

    /**
     * 修改以node为头结点的链表中，第index(0-based)个位置的元素为e，递归算法
     * @param node
     * @param index
     * @param e
     */
    private void set(Node node,int index,E e){
        if (index==0){
            node.e=e;
            return;
        }
        set(node.next, index-1, e);
    }

    /**
     * 查找链表中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(head,e);
    }

    /**
     * 在以node为头结点的链表中，查找是否存在元素e，递归算法
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node,E e){
        if (node==null){
            return false;
        }
        if (node.e.equals(e)){
            return true;
        }
        return contains(node.next, e);
    }

    /**
     * 从链表中删除index(0-based)位置的元素, 返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        Pair<Node, E> res = remove(head, index);
        size --;
        head = res.getKey();
        return res.getValue();
    }

    /**
     * 从以node为头结点的链表中，删除第index位置的元素，递归算法
     * @param node
     * @param index
     * @return 返回值包含两个元素，删除后的链表头结点和删除的值
     */
    private Pair<Node, E> remove(Node node, int index){
        if(index == 0) {
            return new Pair<>(node.next, node.e);
        }
        Pair<Node, E> res = remove(node.next, index - 1);
        node.next = res.getKey();
        return new Pair<>(node, res.getValue());
    }

    /**
     * 删除链表第一个节点
     * @return
     */
    public E removeFirst(){
        return  remove(0);
    }

    /**
     * 删除链表最后一个节点
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 从链表中删除元素e
     * @param e
     */
    public void removeElement(E e){
        head=removeElement(head,e);
    }

    /**
     * 从以node为头结点的链表中，删除元素e，递归算法
     * @param node
     * @param e
     * @return
     */
    private Node removeElement(Node node,E e){
        if (node==null){
            return null;
        }
        if (node.e.equals(e)){
            size--;
            return node.next;
        }
        node.next=removeElement(node.next, e);
        return node;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = head;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}
