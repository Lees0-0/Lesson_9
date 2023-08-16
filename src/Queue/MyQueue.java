package Queue;
public class MyQueue<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public void add(T value) {
        Node<T> newNode = new Node<>(null, value);
        if (last == null) {
            first = newNode;
            last = newNode;
        } else {
            last.setNextNode(newNode);
            last = newNode;
        }
        size++;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        size++;
        return first.getValue();

    }

    public T poll() {
        T value = first.getValue();
        first = first.getNextNode();
        if (first == null) {
            last = null;
        }
        size--;
        return value;
    }
    public static void main(String[] args) {
        MyQueue<Integer> MyQueue = new MyQueue<>();

        MyQueue.add(1);
        MyQueue.add(2);
        MyQueue.add(3);
        MyQueue.add(4);
        MyQueue.add(5);

        System.out.println("MyQueue.size() " + MyQueue.size());

        System.out.println("MyQueue.poll() " + MyQueue.poll());
        System.out.println("MyQueue.size() after poll: " + MyQueue.size());

        System.out.println("MyQueue.peek() " + MyQueue.peek());
        System.out.println("MyQueue.size() after peek " + MyQueue.size());

        MyQueue.clear();
        System.out.println("MyQueue.size() after clear " + MyQueue.size());
    }
}