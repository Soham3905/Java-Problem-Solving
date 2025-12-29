
public class CustomAVLTree {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        for (int i = 0; i < 1000; i++) {
            tree.insert(i);
        }

        System.out.println(tree.height());
    }
}

class AVLTree {

    public AVLTree() {
    }

    private class Node {

        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private Node root;

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        }
        if (value > node.value) {
            node.right = insert(node.right, value);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    private Node rotate(Node node) {
        // left is heavy...
        if (height(node.left) - height(node.right) > 1) {
            // left-left case...
            if (height(node.left.left) - height(node.left.right) > 0) {
                return rightRotate(node);
            }
            // left-right case...
            if (height(node.left.left) - height(node.left.right) < 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        // right is heavy...
        if (height(node.left) - height(node.right) < -1) {
            // right-right case...
            if (height(node.right.left) - height(node.right.right) < 0) {
                return leftRotate(node);
            }
            // right-left case...
            if (height(node.right.left) - height(node.right.right) > 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;

        return p;
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populateSorted(int[] nums) {
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]);

        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
    }

    public void display() {
        display(this.root, "Root Node : ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left Child of " + node.value + " : ");
        display(node.right, "Right Child of " + node.value + " : ");
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isbalanced() {
        return isbalanced(root);
    }

    private boolean isbalanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && isbalanced(node.left) && isbalanced(node.right);
    }

}
