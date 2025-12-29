
import java.util.Arrays;

public class CustomGenArraylist {

    public static void main(String[] args) {
        CustomGenlist<Integer> list = new CustomGenlist<>();
        for (int i = 0; i < 14; i++) {
            list.add(2 * i);
        }

        System.out.println(list);

    }
}

class CustomGenlist<T> {

    private Object[] data;
    private static final int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomGenlist() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(int num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private boolean isFull() {
        return data.length == size;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        // for (int i = 0; i < data.length; i++) {
        //     temp[i] = data[i];
        // }          // same
        data = temp;
    }

    public T remove() {
        T removed = (T) data[--size];
        return removed;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public void set(int index, T value) {
        data[index] = value;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "CustomGenArrayList{"
                + "data=" + Arrays.toString(data)
                + ", size=" + size
                + '}';
    }

}
