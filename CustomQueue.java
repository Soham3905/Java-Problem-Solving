
public class CustomQueue {

    public static void main(String[] args) throws QueueException {
        MyQueue queue = new MyQueue(5);
        queue.insert(3);
        queue.insert(6);
        queue.insert(5);
        queue.insert(19);
        queue.insert(1);
        queue.display();
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.display();
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.display();

    }
}

class MyQueue {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int size = 0;

    public MyQueue() {
        this.data = new int[DEFAULT_SIZE];
    }

    public MyQueue(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return false;
        }
        data[size++] = item;
        return true;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int remove() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Cannot remove from an Empty Queue!!!!");
        }
        int removed = data[0];
        for (int i = 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return removed;
    }

    public int front() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Cannot peek from an Empty Queue!!!!");
        }
        return data[0];
    }

    public void display(){
        for(int i = 0 ; i < size ; i++){
            System.out.print(data[i] + " <- ");
        }
        System.out.println("End");
    }

}

class QueueException extends Exception {

    public QueueException(String message) {
        super(message);
    }

}
