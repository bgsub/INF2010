package tp2;

public class HashMap<KeyType, DataType> {

    private static final int DEFAULT_CAPACITY = 20;
    private static final float DEFAULT_LOAD_FACTOR = 0.5f;
    private static final int CAPACITY_INCREASE_FACTOR = 2;

    private Node<KeyType, DataType>[] map;
    private int size = 0;
    private int capacity;
    private final float loadFactor; // Compression factor

    /**
     * Constructeur par défaut
     */
    public HashMap() { this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR); }

    /**
     * Constructeur par parametre
     * @param initialCapacity
     */
    public HashMap(int initialCapacity) {
        this(initialCapacity > 0 ? initialCapacity : DEFAULT_CAPACITY,
                DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructeur par parametres
     * @param initialCapacity
     * @param loadFactor
     */
    public HashMap(int initialCapacity, float loadFactor) {
        capacity = initialCapacity;
        this.loadFactor = 1 / loadFactor;
        map = new Node[capacity];
    }

    /**
     * Finds the index attached to a particular key
     * This is the hashing function ("Fonction de dispersement")
     * @param key Value used to access to a particular instance of a DataType within map
     * @return Index value where this key should be placed in attribute map
     */
    private int hash(KeyType key){
        int keyHash = key.hashCode() % capacity;
        return Math.abs(keyHash);
    }

    /**
     * @return if map should be rehashed
     */
    private boolean needRehash() {
        return size * loadFactor > capacity;
    }

    /**
     * @return Number of elements currently in the map
     */
    public int size() {
        return size;
    }

    /**
     * @return Current reserved space for the map
     */
    public int capacity(){ return capacity; }

    /**
     * @return if map does not contain any element
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /** TODO
     * Increases capacity by CAPACITY_INCREASE_FACTOR (multiplication) and
     * reassigns all contained values within the new map
     */
    private void rehash() {
        Node<KeyType, DataType>[] oldarray = map;
        map = new Node[capacity*CAPACITY_INCREASE_FACTOR];
        capacity = capacity*CAPACITY_INCREASE_FACTOR;
        size = 0;
        for (int i = 0; i < oldarray.length; i++) {
            while (oldarray[i] != null) {
                put(oldarray[i].key, oldarray[i].data);
                oldarray[i] = oldarray[i].next;
            }
        }
    }

    /** TODO
     * Finds if map contains a key
     * @param key Key which we want to know if exists within map
     * @return if key is already used in map
     */
    public boolean containsKey(KeyType key) {
        Node<KeyType, DataType> tmp = map[hash(key)];
        while (tmp != null) {
            if (tmp.key.equals(key)) return true;
            tmp = tmp.next;
        }
        return false;
    }

    /** TODO
     * Finds the value attached to a key
     * @param key Key which we want to have its value
     * @return DataType instance attached to key (null if not found)
     */
    public DataType get(KeyType key) {
        Node<KeyType, DataType> tmp = map[hash(key)];
        while (tmp != null) {
            if (tmp.key.equals(key)) return tmp.data;
            tmp = tmp.next;
        }
        return null;
    }

    /**TODO
     * Assigns a value to a key
     * @param key Key which will have its value assigned or reassigned
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType put(KeyType key, DataType value) {
        Node<KeyType, DataType> tmp = map[hash(key)];
        while (tmp != null) {
            if (tmp.key.equals(key)) {
                DataType oldData = tmp.data;
                tmp.data = value;
                if (needRehash()) rehash();
                return oldData;
            }
            else if (tmp.next == null) {
                tmp.next = new Node(key, value);
                size++;
                if (needRehash()) rehash();
                return null;
            }
            tmp = tmp.next;
        }
        map[hash(key)] = new Node(key, value);
        size++;
        if (needRehash()) rehash();
        return null;
    }

    
    /**TODO
     * Removes the node attached to a key
     * @param key Key which is contained in the node to remove
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType remove(KeyType key) {
        Node<KeyType, DataType> tmp = map[hash(key)];
        if (tmp != null && tmp.key.equals(key)) {
            DataType oldData = tmp.data;
            map[hash(key)] = tmp.next;
            size--;
            return oldData;
        }
        while (tmp != null) {
            if (tmp.next.key.equals(key)) {
                DataType oldData = tmp.next.data;
                tmp.next = tmp.next.next;
                size--;
                return oldData;
                }
            tmp = tmp.next;
        }
        return null;
    }

    /**TODO
     * Removes all nodes contained within the map
     */
    public void clear() {
        for (int i = 0; i < map.length; i++) {
            if (map[i] == null) continue;
            map[i] = null;
        }
        size = 0;
    }

    /**
     * Definition et implementation de la classe Node
     */
    static class Node<KeyType, DataType> {
        final KeyType key;
        DataType data;
        Node<KeyType, DataType> next; // Pointer to the next node within a Linked List

        Node(KeyType key, DataType data)
        {
            this.key = key;
            this.data = data;
            next = null;
        }
    }
}