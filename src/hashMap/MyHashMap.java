package hashMap;
public class MyHashMap<K, V> {
    private static final int CAP = 16;
    private Node<K, V>[] buckets = new Node[CAP];
    private int size = 0;

    private int hash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode()) % buckets.length;
    }

    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> newNode = new Node<>(key, null, value);

        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            Node<K, V> current = buckets[index];
            Node<K, V> prev = null;

            while (current != null) {
                if (current.getKey().equals(key)) {
                    current.setValue((V) value);
                    return;
                }
                prev = current;
                current = current.getNextNode();
            }

            prev.setNextNode(newNode);
        }

        size++;

        rebalance();
    }

    public void rebalance() {
        if (size >= buckets.length) {
            int newCapacity = buckets.length * 2;
            Node<K, V>[] newBuckets = new Node[newCapacity];

            for (Node<K, V> node : buckets) {
                while (node != null) {
                    Node<K, V> next = node.getNextNode();
                    int newIndex = hash(node.getKey()) % newCapacity;
                    node.setNextNode(newBuckets[newIndex]);
                    newBuckets[newIndex] = node;
                    node = next;
                }
            }
            buckets = newBuckets;
        }
    }

    public void remove(K key) {
        int index = hash(key);
        Node<K, V> current = buckets[index];
        Node<K, V> prev = null;

        while (current != null) {
            if (current.getKey().equals(key)) {
                if (prev == null) {
                    buckets[index] = current.getNextNode();
                } else {
                    prev.setNextNode(current.getNextNode());
                }
                size--;
                return;
            }
            prev = current;
            current = current.getNextNode();
        }
    }

    public void clear() {
        buckets = new Node[CAP];
        size = 0;
    }

    public int size() {
        return size;
    }

    public K get(K key) {
        int index = hash(key);
        Node<K, V> current = buckets[index];

        while (current != null) {
            if (current.getKey().equals(key)) {
                return (K) current.getValue();
            }
            current = current.getNextNode();
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> MyHashMap = new MyHashMap<>();

        MyHashMap.put(1, "Ivan");
        MyHashMap.put(2, "Fedir");
        MyHashMap.put(3, "Alan");

        System.out.println("MyHashMap.size() " + MyHashMap.size());

        System.out.println("MyHashMap.get(2) " + MyHashMap.get(2));
        System.out.println("MyHashMap.get(4) " + MyHashMap.get(4));

        MyHashMap.put(2, "Alla");
        System.out.println("MyHashMap.get(2) after update: " + MyHashMap.get(2));

        MyHashMap.remove(3);
        System.out.println("MyHashMap.size() after removal: " + MyHashMap.size());

        MyHashMap.clear();
        System.out.println("MyHashMap.size() after clearing: " + MyHashMap.size());
    }
}