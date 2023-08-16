package hashMap;
public class MyHashMap<T> {
    private static final int cap = 16;
    private Node<T>[] buckets = new Node[cap];
    private int size = 0;

    private int hash(T key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void put(Integer key, String value) {
        int index = hash((T) key);
        Node<T> newNode = (Node<T>) new Node<>(key, null, value);

        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            Node<T> current = buckets[index];
            Node<T> prev = null;

            while (current != null) {
                if (current.getKey().equals(key)) {
                    current.setValue((T) value);
                    return;
                }
                prev = current;
                current = current.getNextNode();
            }

            prev.setNextNode(newNode);
        }
        size++;
    }

    public void remove(T key) {
        int index = hash(key);
        Node<T> current = buckets[index];
        Node<T> prev = null;

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
        buckets = new Node[cap];
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(T key) {
        int index = hash(key);
        Node<T> current = buckets[index];

        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();
            }
            current = current.getNextNode();
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap<Integer> MyHashMap = new MyHashMap<>();

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