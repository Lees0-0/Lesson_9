package Stack;

public class Node<T> {

    private T value;
    private Node<T> nextNode;

    public Node(Node<T> nextNode, T value) {
        this.nextNode = nextNode;
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}