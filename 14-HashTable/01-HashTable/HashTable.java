import java.util.TreeMap;

public class HashTable<K,V> {
    private TreeMap<K,V>[] hashTable;
    private int size;
    //一个合适的素数
    private int M;

    public HashTable(int M) {
        this.M = M;
        this.size=0;
        hashTable=new TreeMap[M];
        for (int i=0;i<M;i++){
            hashTable[i]=new TreeMap<>();
        }
    }

    public HashTable() {
        this(97);
    }
    private int hash(K key){
        //& 0x7fffffff——>去除符号
        //% M ——>得到相关索引
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key,V value){
        //使用暂存空间优化操作
        TreeMap<K, V> map = hashTable[hash(key)];
        if(map.containsKey(key)) {
            map.put(key, value);
        } else{
            map.put(key, value);
            size ++;
        }
//        不实用暂存空间优化添加操作
//        if (hashTable[hash(key)].containsKey(key)){
//            hashTable[hash(key)].put(key, value);
//        }else {
//            hashTable[hash(key)].put(key, value);
//            size++;
//        }
    }
    public V remove(K key){
        V ret=null;
        TreeMap<K,V>map=hashTable[hash(key)];
        if (map.containsKey(key)){
            ret=map.remove(key);
            size--;
        }
        return ret;
    }

    public void set(K key,V value){
        TreeMap<K,V>map=hashTable[hash(key)];
        if (!map.containsKey(key)){
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        map.put(key, value);
    }
    public boolean contains(K key){
        return hashTable[hash(key)].containsKey(key);
    }
    public V get(K key){
        return hashTable[hash(key)].get(key);
    }
}
