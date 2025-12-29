
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        System.out.println(tree.val);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentlevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentlevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentlevel);
        }
        return result;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double averagelevel = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                averagelevel += currentNode.val;
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            averagelevel /= levelSize;
            result.add(averagelevel);
        }
        return result;
    }

    public TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.val == key) {
                break;
            }
        }
        return queue.peek();
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentlevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                if (!reverse) {
                    TreeNode currentNode = queue.pollFirst();
                    currentlevel.add(currentNode.val);
                    if (currentNode.left != null) {
                        queue.offerLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.offerLast(currentNode.right);
                    }
                } else {
                    TreeNode currentNode = queue.pollLast();
                    currentlevel.add(currentNode.val);
                    if (currentNode.right != null) {
                        queue.offerFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        queue.offerFirst(currentNode.left);
                    }
                }
            }
            reverse = !reverse;
            result.add(currentlevel);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentlevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentlevel.add(currentNode.val);
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
            }
            result.add(currentlevel);
        }
        Collections.reverse(result);
        return result;
    }

    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode leftmost = root;
        while (leftmost.left != null) {
            TreeNode current = leftmost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return ((level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy)));
    }

    public boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) {
            return false;
        }
        return ((node.left == x && node.right == y) || (node.left == y && node.right == x) || isSibling(node.left, x, y) || isSibling(node.right, x, y));
    }

    public int level(TreeNode node, TreeNode x, int lev) {
        if (node == null) {
            return 0;
        }
        if (node == x) {
            return lev;
        }
        int l = level(node.left, x, lev + 1);
        if (l != 0) {
            return l;
        }
        return level(node.right, x, lev + 1);
    }

    public TreeNode findNode(TreeNode node, int x) {
        if (node == null) {
            return null;
        }
        if (node.val == x) {
            return node;
        }
        TreeNode n = findNode(node.left, x);
        if (n != null) {
            return n;
        }
        return findNode(node.right, x);
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public static void topview(TreeNode root){
        
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode() {
        }

        // TreeNode(int val) {
        //     this.val = val;
        // }
        // TreeNode(int val, TreeNode left, TreeNode right) {
        //     this.val = val;
        //     this.left = left;
        //     this.right = right;
        // }
        public TreeNode getNext() {
            return next;
        }

        public void setNext(TreeNode next) {
            this.next = next;
        }
    }
}
