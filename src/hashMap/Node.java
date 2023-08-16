package hashMap;
public class Node<T> {

    private T key;
    private Node<T> nextNode;
    private T value;

    public Node(T key, Node<T> nextNode, T value) {
        this.key = key;
        this.nextNode = nextNode;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
