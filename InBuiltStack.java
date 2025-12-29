
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InBuiltStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(5);
        stack.push(8);
        stack.push(9);
        stack.push(3);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(3);
        queue.add(5);
        queue.add(7);
        queue.add(8);
        queue.add(85);
        queue.add(65);
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(34);
        deque.addFirst(2);
        deque.addLast(5);
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
    }
}
