
import java.util.Stack;

public class QueueUsingStack {

    public static void main(String[] args) throws Exception {
        MyQueueUsingStack queue = new MyQueueUsingStack();
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        MyQUSRemoveEfficiently queue1 = new MyQUSRemoveEfficiently();
        queue1.add(2);
        queue1.add(3);
        queue1.add(4);
        queue1.add(5);
        queue1.add(6);
        queue1.add(7);
        System.out.println(queue1.remove());
        System.out.println(queue1.remove());
        System.out.println(queue1.remove());
        System.out.println(queue1.remove());
        System.out.println(queue1.peek());
    }
}

class MyQueueUsingStack {

    private final Stack<Integer> first;
    private final Stack<Integer> second;

    public MyQueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) {
        first.push(item);
    }

    public int remove() throws Exception {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int removed = second.pop();
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return removed;
    }

    public int peek() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int peeked = second.peek();
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return peeked;
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }

}

class MyQUSRemoveEfficiently {

    private final Stack<Integer> first;
    private final Stack<Integer> second;

    public MyQUSRemoveEfficiently() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        first.push(item);
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
    }

    public int remove() throws Exception {
        return first.pop();
    }

    public int peek() throws Exception {
        return first.peek();
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }

}
