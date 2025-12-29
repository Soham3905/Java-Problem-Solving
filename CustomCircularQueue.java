public class CustomCircularQueue {
    public static void main(String[] args) throws QueueException {
        MyCircularQueue queue = new MyCircularQueue(5);
        queue.insert(3);
        queue.insert(6);
        queue.insert(5);
        queue.insert(19);
        queue.insert(1);

        queue.display();

        System.out.println(queue.remove());
        queue.insert(133);
        queue.display();

        System.out.println(queue.remove());
        queue.insert(99);
        queue.display();
    }
}
class MyCircularQueue{
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int size = 0;
    protected int front = 0;
    protected int end = 0;

    public MyCircularQueue() {
        this.data = new int[DEFAULT_SIZE];
    }

    public MyCircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item){
        if(isFull()){
            System.out.println("Queue is Full");
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Cannot remove from an Empty Queue!!!!");
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    public int front() throws QueueException{
        if (isEmpty()) {
            throw new QueueException("Cannot peek from an Empty Queue!!!!");
        }
        return data[front];
    }

    public void display(){
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        int i = front;
        do { 
            System.out.print(data[i] + " <- ");
            i++;
            i %= data.length;
        } while (i != end);
        System.out.println("End");
    }

    private boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
class QueueException extends Exception {

    public QueueException(String message) {
        super(message);
    }

}

