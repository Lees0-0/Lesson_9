package hashMap;
public class Node<K, V> {

    private K key;
    private Node<K, V> nextNode;
    private V value;

    public Node(K key, Node<K, V> nextNode, V value) {
        this.key = key;
        this.nextNode = nextNode;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public Node<K, V> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<K, V> nextNode) {
        this.nextNode = nextNode;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

