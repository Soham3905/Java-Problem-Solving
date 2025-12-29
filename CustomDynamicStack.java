
public class CustomDynamicStack {

    public static void main(String[] args) throws StackException {
        MyDynamicStack stack = new MyDynamicStack(5);

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

    }
}

class MyDynamicStack {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int size = -1;

    public MyDynamicStack() {
        this.data = new int[DEFAULT_SIZE];
    }

    public MyDynamicStack(int size) {
        this.data = new int[size];
    }

    public void push(int item) {
        if (isFull()) {
            resize();
        }
        size++;
        data[size] = item;
    }

    private boolean isFull() {
        return size == data.length - 1;
    }

    private void resize() {
        int[] temp = new int[data.length * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
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
