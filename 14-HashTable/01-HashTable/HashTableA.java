import java.util.TreeMap;

public class HashTableA<K,V> {
    //素数表
    private final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};
    private static  final int upperTol=10;
    private static  final int lowerTol=2;
    private int capacityIndex = 0;
    private TreeMap<K,V>[] hashTable;
    private int size;
    //一个合适的素数
    private int M;

    public HashTableA() {
        this.M = capacity[capacityIndex];
        this.size=0;
        hashTable=new TreeMap[M];
        for (int i=0;i<M;i++){
            hashTable[i]=new TreeMap<>();
        }
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
            if (size>=upperTol*M&&capacityIndex+1<capacity.length){
                capacityIndex++;
                resize(capacity[capacityIndex]);
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
            if (size<lowerTol*M && capacityIndex-1>=0){
                capacityIndex--;
                resize(capacity[capacityIndex]);
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
