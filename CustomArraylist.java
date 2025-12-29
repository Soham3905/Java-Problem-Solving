
import java.util.Arrays;

public class CustomArraylist {

    public static void main(String[] args) {
        CustomList list = new CustomList();
        for (int i = 0; i < 14; i++) {
            list.add(2 * i);
        }

        System.out.println(list);
    }
}

class CustomList {

    private int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int size = 0; //also working as a index...

    public CustomList() {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void resize() {
        int[] temp = new int[data.length * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        // for (int i = 0; i < data.length; i++) {
        //     temp[i] = data[i];
        // }          // same
        data = temp;
    }

    @Override
    public String toString() {
        return "CustomArrayList{"
                + "data=" + Arrays.toString(data)
                + ", size=" + size
                + '}';
    }

    public int remove() {
        int removed = data[--size];
        return removed;
    }

    public void set(int index, int value) {
        data[index] = value;
    }

    public int get(int index) {
        return data[index];
    }

    public int size() {
        return size;
    }
}
