
public class CustomLinkedList {

    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(5);
        list.insertFirst(7);
        list.insertFirst(9);
        list.insertFirst(2);
        list.insertFirst(4);
        list.insertFirst(8);

        list.display();
        list.insertlast(10);
        list.display();
        list.insert(100, 3);
        list.display();
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.delete(2));
        list.display();
        System.out.println(list.find(2));
        list.insertRec(3, 90);
        list.display();
        LL list1 = new LL();
        list1.insertlast(1);
        list1.insertlast(1);
        list1.insertlast(1);
        list1.insertlast(1);
        list1.insertlast(2);
        list1.insertlast(2);
        list1.insertlast(4);
        list1.insertlast(4);
        list1.display();
        list1.duplicates();
        list1.display();
        LL first = new LL();
        LL second = new LL();

        first.insertlast(1);
        first.insertlast(3);
        first.insertlast(5);
        second.insertlast(1);
        second.insertlast(2);
        second.insertlast(9);
        second.insertlast(14);

        LL ans = LL.merge1(first, second);
        ans.display();

        LL list2 = new LL();
        list2.insertlast(5);
        list2.insertlast(4);
        list2.insertlast(3);
        list2.insertlast(2);
        list2.insertlast(1);
        list2.display();
        list2.bubbleSort();
        list2.display();
    }
}

class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("End");
        System.out.println();
    }

    public void insertlast(int value) {
        if (tail == null) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void insert(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertlast(value);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(temp.next, value);
        temp.next = node;
        size += 1;
    }

    // insert using Recurrsion.....
    public void insertRec(int index, int value) {
        head = insertRec(index, value, head);
    }

    private Node insertRec(int index, int value, Node node) {
        if (index == 0) {
            Node temp = new Node(node, value);
            size++;
            return temp;
        }
        node.next = insertRec(index - 1, value, node.next);
        return node;
    }

    public int deleteFirst() {
        int value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        Node secondlast = get(size - 2);
        int value = tail.value;
        tail = secondlast;
        tail.next = null;
        size--;
        return value;
    }

    public int getSize() {
        return size;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {         // I think it should be size not size-1..
            return deleteLast();
        }
        Node prev = get(index - 1);
        int value = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return value;
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

    // Questions....
    public void duplicates() {
        Node node = head;

        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    public static LL merge1(LL first, LL second) {
        Node f = first.head;
        Node s = second.head;
        LL ans = new LL();
        while (f != null && s != null) {
            if (f.value < s.value) {
                ans.insertlast(f.value);
                f = f.next;
            } else {
                ans.insertlast(s.value);
                s = s.next;
            }
        }
        while (f != null) {
            ans.insertlast(f.value);
            f = f.next;
        }
        while (s != null) {
            ans.insertlast(s.value);
            s = s.next;
        }
        return ans;
    }

    public static boolean hasCycle(LL list) {
        Node f = list.head;
        Node s = list.head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if (f == s) {
                return true;
            }
        }
        return false;
    }

    public static int lengthCycle(LL list) {
        int count = 0;
        Node f = list.head;
        Node s = list.head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if (f == s) {
                s = s.next;
                count++;
                while (f != s) {
                    s = s.next;
                    count++;
                }
                break;
            }
        }
        return count;
    }

    public static Node detectCycle(LL list) {
        int count = 0;
        Node f = list.head;
        Node s = list.head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if (f == s) {
                s = s.next;
                count++;
                while (f != s) {
                    s = s.next;
                    count++;
                }
                break;
            }
        }
        if (count == 0) {
            return null;
        }

        Node first = list.head;
        Node second = list.head;

        while (count > 0) {
            second = second.next;
            count--;
        }

        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first; // return second..
    }

    public Node middleNode(Node head) {
        Node f = head;
        Node s = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);
            if (first.value > second.value) {
                // swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = first;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        }
        bubbleSort(row - 1, 0);
    }

    // Reverse using Recursion....
    public void reverse(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // In place reversal of Linked List......
    public void reverse() {
        if (size < 2) {
            return;
        }
        Node prev = null;
        Node pres = head;
        Node next = pres.next;

        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = prev;
    }

    public Node reverseBetween(Node head, int left, int right) {
        if (left == right) {
            return head;
        }
        Node prev = null;
        Node current = head;

        for (int i = 0; i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        Node last = prev;
        Node newEnd = current;
        Node next = current.next;

        for (int i = 0; i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = current;
        return head;
    }

    public boolean isPalindrome(Node head) {
        Node mid = middleNode(head);
        Node secondhead = reverselist(mid);
        Node rereverse = secondhead;
        while (head != null && secondhead != null) {
            if (head.value != secondhead.value) {
                break;
            }
            head = head.next;
            secondhead = secondhead.next;
        }
        reverselist(rereverse);
        return head == null || secondhead == null;
    }

    public Node reverselist(Node head) {
        if (head == null) {
            return head;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public void reorderList(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node mid = middleNode(head);
        Node hs = reverselist(mid);
        Node hf = head;
        // rearrange
        while (hf != null && hs != null) {
            Node temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        if (hf != null) {
            hf.next = null;
        }
    }

    public Node reverseKNodes(Node head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }
        Node prev = null;
        Node current = head;

        while (true) {

            Node last = prev;
            Node newEnd = current;
            Node next = current.next;

            for (int i = 0; i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }
            newEnd.next = current;
            if (current == null) {
                break;
            }
            prev = newEnd;
        }
        return head;

    }

    public Node reverseAlternateKNodes(Node head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }
        Node prev = null;
        Node current = head;

        while (current != null) {

            Node last = prev;
            Node newEnd = current;
            Node next = current.next;

            for (int i = 0; i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }
            newEnd.next = current;
            for (int i = 0; current != null && i < k; i++) {
                prev = current;
                current = current.next;
            }
        }
        return head;

    }

    public Node rotateListRight(Node head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }
        Node last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }
        last.next = head;
        int rotations = k % length;
        int skip = length - rotations;
        Node newLast = head;
        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;
        return head;
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
