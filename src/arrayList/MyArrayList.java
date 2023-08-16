package arrayList;
import java.util.Arrays;

public class MyArrayList <T> {
    private Object[] values = new Object[10];
    private int size = 0;

    public void add(T obj) {
        rebalance();
        values[size] = obj;
        size++;
    }

    public void rebalance() {
        if(values.length == size) {
            values = Arrays.copyOf(values, values.length +5);
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
        for (int i = 0; i < size; i++) {
            values[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return (T) values[index];
    }
    public static void main(String[] args) {
        MyArrayList MyArrayList = new MyArrayList();

        MyArrayList.add(1632);
        MyArrayList.add("Java ");
        MyArrayList.add(12352.123);

        System.out.println("MyArrayList.size() " + MyArrayList.size());
        System.out.println("MyArrayList.get(1) " + MyArrayList.get(1));

        MyArrayList.remove(0);

        System.out.println("MyArrayList.size() after removal: " + MyArrayList.size());
        System.out.println("MyArrayList.get(0) after removal: " + MyArrayList.get(0));

        MyArrayList.clear();
        System.out.println("MyArrayList.size() after clearing: " + MyArrayList.size());
    }
}