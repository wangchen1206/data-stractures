import java.util.TreeMap;

/**
 * @Author: cc
 * @Date: 2020/1/10 14:55
 */
public class HashTable<K, V> {
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapasity = 7;

    private TreeMap<K, V>[] hashtable;
    private int M;
    private int size;

    public HashTable(int M) {
        this.M = M;
        this.size = 0;
        this.hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            this.hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(initCapasity);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return this.size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = this.hashtable[hash(key)];
        if (map.containsKey(key))
            map.put(key, value);
        else {
            map.put(key, value);
            size++;
            if (size >= upperTol * M)
                resize(2 * M);
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = this.hashtable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.get(key);
            size--;
            if (size < lowerTol * M && M / 2 >= initCapasity)
                resize(M / 2);
        }
        return ret;
    }



    public void set(K key, V value) {
        TreeMap<K, V> map = this.hashtable[hash(key)];
        if (!map.containsKey(key))
            throw new IllegalArgumentException(key + " doesn't exist!");
        map.put(key, value);
    }

    public boolean contains(K key) {
        return this.hashtable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return this.hashtable[hash(key)].get(key);
    }

    private void resize(int newM) {
        TreeMap<K,V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        int oldM = this.M;
        //这里为了重新计算hash值，用新的M值
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K,V> map = this.hashtable[i];
            for (K key:map.keySet()){
                //重新根据hash值放入新的newHashTable
                newHashTable[hash(key)].put(key,map.get(key));
            }
        }
        this.hashtable = newHashTable;
    }
}
