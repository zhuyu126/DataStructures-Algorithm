import java.util.TreeMap;

public class TrieR {
    private class Node{
        private boolean isWord;
        private TreeMap<Character,Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next=new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }
    private int size;
    private Node root;

    public TrieR() {
        this.root=new Node();
        this.size=0;
    }

    /**
     * 获得Trie中存储的单词数量
     * @return size
     */
    public int getSize(){
        return size;
    }
    /**
     * 向Trie中添加一个新的单词word 递归接口
     * @param word 新单词
     */
    public void addR(String word){
        Node cur=root;
        addR(root,word,0);
    }

    /**
     * 向Trie中添加一个新的单词word 递归实现
     * @param node 添加节点
     * @param word 新单词
     * @param index 添加单词索引
     */
    private void addR(Node node, String word, int index) {
        if (!node.isWord&&index==word.length()){
            node.isWord=true;
            size++;
        }
        if (index<word.length()){
            char c=word.charAt(index);
            if (node.next.get(c)==null){
                node.next.put(c,new Node());
            }
            addR(node.next.get(c),word,index+1);
        }
    }

    /**
     *  查询单词word是否在Trie中 递归接口
     * @param word 查询单词
     * @return 是否存在
     */
    public boolean containsR(String word){
        Node cur=root;
        return containsR(root,word,0);
    }

    /**
     * 查询单词word是否在Trie中 递归实现
     * @param node 查询节点
     * @param word 查询单词
     * @param index 查询单词索引
     * @return 是否存在
     */
    private boolean containsR(Node node, String word, int index) {
        if (index==word.length()){
            return node.isWord;
        }
        char c=word.charAt(index);
        if (node.next.get(c)==null){
            return false;
        }else {
            return containsR(node.next.get(c),word,index+1);
        }
    }
    /**
     *  查询是否在Trie中有单词以prefix为前缀 递归接口
     * @param prefix 前缀单词
     * @return 是否存在
     */
    public boolean isPrefixR(String prefix){
        Node cur=root;
        return containsR(root,prefix,0);
    }

    /**
     * 查询是否在Trie中有单词以prefix为前缀 递归实现
     * @param node 查询节点
     * @param prefix 前缀单词
     * @param index 查询单词索引
     * @return 是否存在
     */
    private boolean isPrefixR(Node node, String prefix, int index) {
        if (index==prefix.length()){
            return true;
        }
        char c=prefix.charAt(index);
        if (node.next.get(c)==null){
            return false;
        }else {
            return containsR(node.next.get(c),prefix,index+1);
        }
    }
}
