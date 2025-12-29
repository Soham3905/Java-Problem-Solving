
public class CustomDoublyLinkedList {

    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertFirst(2);
        list.insertFirst(5);
        list.insertFirst(7);
        list.insertFirst(9);
        list.insertFirst(55);
        list.insertFirst(95);
        list.insertFirst(3);
        list.display();
        list.insertLast(4);
        list.display();
        list.insert(4, 89);
        list.display();
    }
}

class DLL {

    private Node head;
    private Node tail;
    private int size;

    public DLL() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        size += 1;
    }

    public void display() {
        Node node = head;
        Node last = null;
        while (node != null) {
            System.out.print(node.value + " <-> ");
            last = node;
            node = node.next;
        }
        System.out.println("End");
        System.out.println("Print in Reverse Order");
        while (last != null) {
            System.out.print(last.value + " <-> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    // public void insertLast(int value){
    //     if (tail == null) {
    //         insertFirst(value);
    //         return;
    //     }
    //     Node node = new Node(value);
    //     tail.next = node;
    //     node.prev = tail;
    //     node.next = null;
    //     tail = node;
    // }
    public void insertLast(int value) {
        Node node = new Node(value);
        Node last = head;
        if (head == null) {
            node.prev = null;
            head = node;
            size += 1;
            return;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;
        node.next = null;
        size += 1;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insert(int after, int value) {
        Node p = find(after);
        if (p == null) {
            System.out.println("Does not Exist..");
            return;
        }
        Node node = new Node(value);
        if (p.next != null) {
            node.next = p.next;
        }
        p.next = node;
        node.prev = p;
        if (node.next != null) {
            node.next.prev = node;
        }
    }

    public int getSize() {
        return size;
    }

    public Node getTail() {
        return tail;
    }
    
    private class Node {

        private int value;
        private Node prev;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node next, Node prev, int value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
}
