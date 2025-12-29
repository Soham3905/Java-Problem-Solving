
public class CustomStack {

    public static void main(String[] args) throws StackException {
        MyStack stack = new MyStack(5);

        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(18);
        stack.push(18);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}

class MyStack {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int size = -1;

    public MyStack() {
        this.data = new int[DEFAULT_SIZE];
    }

    public MyStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item) {
        if (isFull()) {
            System.out.println("Stack is Full");
            return false;
        }
        size++;
        data[size] = item;
        return true;
    }

    private boolean isFull() {
        return size == data.length - 1;
    }

    public boolean isEmpty() {
        return size == -1;
    }

    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Cannot pop from an Empty List!!!!");
        }
        int removed = data[size];
        size--;
        return removed;
    }

    public int peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("Cannot peek from an Empty List!!!!");
        }
        return data[size];
    }

}

class StackException extends Exception {

    public StackException(String message) {
        super(message);
    }

}
