import java.util.TreeMap;

public class HashTable<K,V> {
    private static  final int upperTol=10;
    private static  final int lowerTol=2;
    private static  final int initCapacity=7;
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
        this(initCapacity);
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
            if (size>=upperTol*M){
                resize(2*M);
            }
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
            if (size<lowerTol*M && M/2>=initCapacity){
                resize(M/2);
            }
        }
        return ret;
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i=0;i<newM;i++){
            newHashTable[i]=new TreeMap<>();
        }
        int oldM=M;
        this.M=newM;
        for (int i=0;i<oldM;i++){
            TreeMap<K, V> map = hashTable[i];
            for (K key:map.keySet()){
                newHashTable[hash(key)].put(key,map.get(key));
            }
        }
        this.hashTable=newHashTable;
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
