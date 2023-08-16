package Stack;
public class MyStack <T> {
    private Node<T> first;
    private int size;

    public void push(T value) {
        Node<T> newNode = new Node<>(first, value);
        first = newNode;
        size++;
    }

    public void remove(int index) {
        if (index == 0) {
            first = first.getNextNode();
        } else {
            Node<T> prevNode = first;
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.getNextNode();
            }
            prevNode.setNextNode(prevNode.getNextNode().getNextNode());
        }
        size--;
    }

    public void clear() {
        first = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return first.getValue();
    }

    public T pop() {
        T poppedValue = first.getValue();
        first = first.getNextNode();
        size--;
        return poppedValue;
    }

    public static void main(String[] args) {
        MyStack<Integer> MyStack = new MyStack<>();
        MyStack.push(1);
        MyStack.push(2);
        MyStack.push(3);

        System.out.println("MyStack.peek() " + MyStack.peek());

        System.out.println("MyStack.pop() " + MyStack.pop());
        System.out.println("MyStack.pop() " + MyStack.pop());

        MyStack.push(4);

        System.out.println("MyStack.size() " + MyStack.size());

        MyStack.remove(0);

        System.out.println("MyStack.size() " + MyStack.size());

        MyStack.clear();

        System.out.println("MyStack.size() " + MyStack.size());


    }
}