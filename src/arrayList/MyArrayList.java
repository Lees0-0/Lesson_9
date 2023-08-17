package arrayList;
import java.util.Arrays;

public class MyArrayList <T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] values = new Object[DEFAULT_CAPACITY];
    private int size = 0;

    public void add(T obj) {
        rebalance();
        values[size] = obj;
        size++;
    }

    public void rebalance() {
        if(values.length == size) {
            values = Arrays.copyOf(values, values.length * 2);
        }
    }

    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            values[i] = values[i + 1];
        }
        values[size - 1] = null;
        size--;
    }

    public void clear() {
        values = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return (T) values[index];
    }
    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public static void main(String[] args) {
        MyArrayList<Integer> integerList = new MyArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            integerList.add(i);
        }

        MyArrayList<String> stringList = new MyArrayList<>();
        MyArrayList<Double> doubleList = new MyArrayList<>();

        integerList.add(1632);
        integerList.add(1542);
        integerList.add(163212);
        integerList.add(163412);
        integerList.add(16);

        stringList.add("Hello");
        stringList.add("World");
        stringList.add("I");
        stringList.add("Love");
        stringList.add("Java");

        doubleList.add(12352.123);
        doubleList.add(152346.163);
        doubleList.add(34563456.243);

        System.out.println("integerList.size(): " + integerList.size());
        System.out.println("stringList.size() = " + stringList.size());
        System.out.println("doubleList.size() = " + doubleList.size());


        System.out.println("stringList.get(0): " + stringList.get(0));
        System.out.println("integerList.get(4) = " + integerList.get(4));
        System.out.println("doubleList.get(3) = " + doubleList.get(3));


        System.out.println("integerList.get(0) = " + integerList.get(0));
        integerList.remove(0);

        System.out.println("integerList.get(0) after removal: " + integerList.get(0));
        System.out.println("integerList.size() after removal: " + integerList.size());

        integerList.clear();
        System.out.println("integerList.size() after clearing: " + integerList.size());
    }
}