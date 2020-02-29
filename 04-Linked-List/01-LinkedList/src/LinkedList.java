/**
 * 	链表时间复杂度:
 * 	1.添加操作  O(n): addLast(e) => O(n), addFirst(e) => O(1), add(index, e) => O(n/2) = O(n)
 *  2.删除操作  O(n): removeLast(e) => O(n), removeFirst => O(1), remove(index, e) => O(n/2) = O(n)
 *  3.修改操作  O(n): set(e) => O(n)
 *  4.查找操作  O(n): get(index) => O(n), contains(e) => O(n)
 * 	整体来看: 我们的链表操作时间复杂度为O(n), 貌似效率上比较数组要低, 但是我们注意一点:
 * 			链表的头操作 addFirst(e) => O(1), removeFirst => O(1) 时间复杂度均为O(1)
 * 			所以一般我们操作链表只操作链表的头部
 * @param <E>
 */
public class LinkedList<E> {
    /**
     * 节点类
     */
    private class Node{
        public E e;
        public Node next;

        /**
         * 构造函数
         * @param e 用户传入
         * @param next 用户传入
         */
        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }

        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        /**
         * 打印Node信息
         * @return
         */
        @Override
        public String toString() {
            return e.toString();
        }
    }

    //private Node head;//头节点
    private Node dummyHead;//虚拟头节点
    private int size;//链表大小

    /**
     * 头节点构造函数
     */
    //public LinkedList(){
        //head=null;
        //size=0;
    //}

    /**
     * 虚拟头节点
     * @return
     */
    public LinkedList(){
        dummyHead=new Node(null,null);
        size=0;
    }

    //获取链表中元素个数
    public int getSize() {
        return size;
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //在链表index(0-based)位置添加新元素e
    //在链表中不是一个常用操作，练习中常用
    public void add(int index,E e){
        if(index<0||index>size){
            throw new IllegalArgumentException("Add failed,Illegal index");
        }
        /*
            不含虚拟头节点的添加方式
         */
//        if(index==0){
//            addFirst(e);
//        }
//        else {
            Node prev=dummyHead;
            for(int i=0;i<index;i++){
                prev=prev.next;
            }
            //Node node=new Node(e);
            //node.next=prev.next;
            //prev.next=node;
            prev.next=new Node(e,prev.next);
            size++;
        //}
    }

    //在链表头添加新元素
    public void addFirst(E e){
        //Node node=new Node(e);
        //node.next=head;
        //head=node;
        /*
        不含虚拟头节点的方式
         */
        /*
        head=new Node(e,head);
        size++;
        */
        add(0,e);
    }
    //在链表末尾添加元素e
    public void addLast(E e){
        add(size,e);
    }

    //获得链表index(0-based)位置元素e
    //在链表中不是一个常用操作，练习中常用
    public E get(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Get failed,Illegal index");
        }
        //从当前真实节点开始遍历, 也就是第0个节点
        Node cur=dummyHead.next;
        //获取第index位置的元素
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.e;
    }
    //获取第一个节点 头节点
    public E getFirst(){
        return get(0);
    }

    //获取最后一个节点 尾部节点
    public E getLast(){
        return get(size-1);
    }

    //修改链表的第index(0-based)个位置的元素为e
    //在链表中不是一个常用的操作
    public void set(int index,E e){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Update failed,Illegal index");
        }
        Node cur=dummyHead.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
            cur.e=e;//进行新的赋值
        }
    }

    //查找链表中是否有元素e
    public boolean contains(E e){
        Node cur=dummyHead.next;
        while(cur!=null) {
            if (cur.e.equals( e )) {
                return true;
            } else {
                cur=cur.next;
            }
        }
        return false;
    }

    public E remove(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Remove failed,Illegal index");
        }
        //	获取虚拟头节点
        Node prev = dummyHead;
        //查找待删除节点的前一个节点
        for(int i =0; i < index; i ++) {
            prev = prev.next;
        }
        //获取待删除前一个节点的下一个节点: 也就是我们的待删除节点
        Node delNode=prev.next;
        //将待删除前一个节点的next指向 待删除节点的下一个节点
        prev.next=delNode.next;
        //将待删除节点设置为null 脱离链表
        delNode.next=null;
        size--;
        return delNode.e;//返回删除节点
    }
    //删除链表第一个节点
    public E removeFirst(){
        return  remove(0);
    }
    //删除链表最后一个节点
    public E removeLast(){
        return remove(size-1);
    }

    // 从链表中删除元素e
    public void removeElement(E e){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }
    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
//        Node cur=dummyHead.next;
//        while(cur!=null){
//            res.append(cur+"->");
//            cur=cur.next;
//        }
        for(Node cur=dummyHead.next;cur!=null;cur=cur.next){
            res.append(cur+"->");
        }
        res.append("null");
        return res.toString();
    }
}
