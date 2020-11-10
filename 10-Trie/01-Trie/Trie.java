import java.util.TreeMap;

public class Trie {
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

    public Trie() {
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
     * 向Trie中添加一个新的单词word 非递归
     * @param word
     */
    public void add(String word){
        Node cur=root;
        for (int i=0;i< word.length();i++){
            char c=word.charAt(i);
            if (cur.next.get(c)==null){
                cur.next.put(c,new Node());
            }
            cur=cur.next.get(c);
        }
        if (!cur.isWord){
            cur.isWord=true;
            size++;
        }
    }

    /**
     * 查询单词word是否在Trie中 非递归实现
     * @param word 查询的单词
     * @return 是否存在
     */
    public boolean contains(String word){
        Node cur=root;
        for (int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if (cur.next.get(c)==null){
                return false;
            }
            cur=cur.next.get(c);
        }
        return cur.isWord;
    }
    public boolean isPrefix(String prefix){
        Node cur=root;
        for (int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if (cur.next.get(c)==null){
                return false;
            }
            cur=cur.next.get(c);
        }
        return true;
    }
}
