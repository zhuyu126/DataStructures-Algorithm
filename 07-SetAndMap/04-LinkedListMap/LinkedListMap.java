public class LinkedListMap<K,V> implements Map<K,V> {
    /**
     * 节点类
     */
    private class Node {
        public K key;
        public V value;
        public Node next;


        /**
         * 构造函数
         * @param key   键
         * @param value 值
         * @param next  下一节点
         */
        public Node(K key, V value, Node next) {
            this.key=key;
            this.value=value;
            this.next=next;
        }
        public Node(K key,V value){
            this(key,value,null);
        }
        public Node(){
            this(null,null,null);
        }

        @Override
        public String toString() {
            return key.toString()+":"+value.toString();
        }
    }
    private Node dummyHead;//虚拟头节点
    private int size;

    /**
     * 虚拟头节点初始化
     */
    public LinkedListMap(){
        dummyHead=new Node(null,null,null);
        size=0;
    }

    /**
     * 节点查找辅助函数
     * @param key 键
     * @return node 节点
     */
    private Node getNode(K key){
        Node cur=dummyHead.next;
        while (cur!=null){
            if(cur.key.equals(key)){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }
    @Override
    public void add(K key, V value) {
        Node node=getNode(key);
        if(node==null){
            dummyHead.next=new Node(key,value,dummyHead.next);
            size++;
        }else {
            node.value=value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev= dummyHead;
        while(prev.next!=null){
            if(prev.next.key.equals(key)){
                break;
            }
            prev=prev.next;
        }
        if(prev.next!=null){
            Node delNode=prev.next;
            prev.next=delNode.next;
            delNode.next=null;
            size--;
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key)!=null;
    }

    @Override
    public V get(K key) {
        Node node=getNode(key);
        return node==null?null:node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node=getNode(key);
        if(node==null){
            throw new IllegalArgumentException(key+"doesn't exist!");
        }else {
            node.value=newValue;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
