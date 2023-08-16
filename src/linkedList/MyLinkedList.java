package linkedList;
public class MyLinkedList<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    public void add(T val) {
        if(firstNode == null) {
            firstNode = new Node<>(null, null, val);
        } else if (lastNode == null) {
            lastNode = new Node<>(firstNode, null, val);
            firstNode.setNextNode(lastNode);
        } else {
            Node<T> node = new Node<>(lastNode, null, val);
            lastNode.setNextNode(node);
            lastNode = node;
        }
        size++;
    }

    private Node<T> getNodeAtIndex(int index) {
        Node<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }
    public T remove(int index) {
        Node<T> nodeToRemove = getNodeAtIndex(index);
        Node<T> prevNode = nodeToRemove.getPrevNode();
        Node<T> nextNode = nodeToRemove.getNextNode();

        if (prevNode == null) {
            firstNode = nextNode;
        } else {
            prevNode.setNextNode(nextNode);
            nodeToRemove.setPrevNode(null);
        }

        if (nextNode == null) {
            lastNode = prevNode;
        } else {
            nextNode.setPrevNode(prevNode);
            nodeToRemove.setNextNode(null);
        }
        size--;
        return nodeToRemove.getValue();
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        Node<T> currentNode = firstNode;
        for(int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getValue();
    }

    public static void main(String[] args) {
        MyLinkedList<String> MyLinkedList = new MyLinkedList<>();
        MyLinkedList.add("Hello");
        MyLinkedList.add("From");
        MyLinkedList.add("Go");
        MyLinkedList.add("IT");
        MyLinkedList.add("Test2");
        MyLinkedList.add("Test3");
        MyLinkedList.add("Test4");
        MyLinkedList.add("Test5");
        MyLinkedList.add("Test6");


        System.out.println(MyLinkedList.size());

        System.out.println("MyLinkedList.get(0) = " + MyLinkedList.get(0));
        System.out.println("MyLinkedList.get(1) = " + MyLinkedList.get(1));
        System.out.println("MyLinkedList.get(2) = " + MyLinkedList.get(2));
        System.out.println("MyLinkedList.get(3) = " + MyLinkedList.get(3));


        MyLinkedList.remove(2);

        System.out.println("MyLinkedList.get(2) after removal = " + MyLinkedList.get(2));
        System.out.println("MyLinkedList.size() after removal = " + MyLinkedList.size());

        MyLinkedList.clear();
        System.out.println("MyLinkedList.size() after clear = " + MyLinkedList.size());
    }
}