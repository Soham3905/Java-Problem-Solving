
public class MinHeapImplementationArray {

    public static void main(String[] args) throws Exception {
        MinHeap pq = new MinHeap(10);
        pq.add(23);
        pq.add(78);
        pq.add(2);
        pq.display();
        System.out.println(pq.size());
        pq.add(9);
        System.out.println(pq.size());
        System.out.println(pq.peek());
        pq.display();
        System.out.println(pq.remove());
        pq.display();
        System.out.println(pq.size());
        System.out.println(pq.remove());
        pq.display();
        System.out.println(pq.size());
        System.out.println(pq.remove());
        pq.display();
        System.out.println(pq.size());
        System.out.println(pq.remove());
        pq.display();
        System.out.println(pq.size());
        System.out.println(pq.remove());
        pq.display();
        System.out.println(pq.size());
    }
}

class MinHeap {

    int[] arr;
    private int size;

    MinHeap(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    public void add(int value) throws Exception {
        if (size == arr.length) {
            throw new Exception("Heap Overflow!!");
        }
        arr[size++] = value;
        upHeapify(size - 1);
    }

    private void upHeapify(int i) {
        if (i == 0) {
            return;
        }
        int parent = (i - 1) / 2;
        if (arr[parent] > arr[i]) {
            swap(parent, i);
        }
        upHeapify(parent);
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int size() {
        return size;
    }

    public int peek() throws Exception {
        if (size == 0) {
            throw new Exception("Heap is Empty!!");
        }
        return arr[0];
    }

    public int remove() throws Exception {
        if (size == 0) {
            throw new Exception("Cannot Remove...Heap is Empty!!");
        }
        int deleted = arr[0];
        swap(0, size - 1);
        size--;
        downHeapify(0);
        return deleted;
    }

    private void downHeapify(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < size && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < size && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(smallest, i);
            downHeapify(smallest);
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
