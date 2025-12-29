
public class CustomCircularLinkedList {

    public static void main(String[] args) {
        CLL list = new CLL();
        list.insert(2);
        list.insert(4);
        list.insert(6);
        list.insert(9);
        list.insert(19);
        list.insert(44);
        list.display();
        list.delete(19);
        list.display();
    }
}

class CLL {

    private Node head;
    private Node tail;
    private int size;

    public CLL() {
        this.size = 0;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display() {
        Node node = head;
        do {
            System.out.print(node.value + " -> ");
            node = node.next;
        } while (node != head);
        System.out.println("HEAD");
    }

    public void delete(int value) {
        Node node = head;
        if (node == null) {
            return;
        }
        if (node.value == value) {
            head = head.next;
            tail.next = head;
            return;
        }
        do {
            Node n = node.next;
            if (n.value == value) {
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != head);
    }

    public int getSize() {
        return size;
    }

    private class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }
    }
}
