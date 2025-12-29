
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DFS {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        System.out.println(tree.val);
    }
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter - 1;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(dia, diameter);

        return Math.max(leftHeight, rightHeight) + 1;

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public int maxDepth(TreeNode root) {
        return height(root);
    }

    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }
        if (low != null && node.val <= low) {
            return false;
        }
        if (high != null && node.val >= high) {
            return false;
        }
        boolean left = helper(node.left, low, node.val);
        boolean right = helper(node.right, node.val, high);
        return left && right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null && right == null) {
            return left;
        } else {
            return right;
        }
    }

    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        return helper2(root, k).val;
    }

    public TreeNode helper2(TreeNode node, int k) {
        if (node == null) {
            return null;
        }
        TreeNode left = helper2(node.left, k);
        if (left != null) {
            return left;
        }
        count++;
        if (k == count) {
            return node;
        }
        return helper2(node.right, k);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int r = preorder[0];
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == r) {
                index = i;
            }
        }
        TreeNode node = new TreeNode(r);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return node;
    }

    public List<String> serialize(TreeNode node) {
        List<String> list = new ArrayList<>();
        helper5(node, list);
        return list;
    }

    public void helper5(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("null");
            return;
        }
        list.add(String.valueOf(node.val));
        helper5(node.left, list);
        helper5(node.right, list);
    }

    public TreeNode deserialize(List<String> list) {
        Collections.reverse(list);
        TreeNode node = helper6(list);
        return node;
    }

    public TreeNode helper6(List<String> list) {
        String value = list.remove(list.size() - 1);
        if (value.charAt(0) == 'n') {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = helper6(list);
        node.right = helper6(list);
        return node;

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public int sumNumbers(TreeNode root) {
        return helper3(root, 0);
    }

    public int helper3(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = (sum * 10) + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return helper3(root.left, sum) + helper3(root.right, sum);
    }
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper4(root);
        return ans;
    }

    public int helper4(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper4(root.left);
        int right = helper4(root.right);
        left = Math.max(0, left);
        right = Math.max(0, right);
        int pathSum = left + right + root.val;
        ans = Math.max(ans, pathSum);
        return Math.max(left, right) + root.val;
    }

    public boolean findPath(TreeNode node, int[] arr) {
        if (node == null) {
            return arr.length == 0;
        }
        return helper7(node, arr, 0);
    }

    public boolean helper7(TreeNode node, int[] arr, int index) {
        if (node == null) {
            return false;
        }
        if (index >= arr.length || node.val != arr[index]) {
            return false;
        }
        if ((node.left == null) && (node.right == null) && (index == (arr.length - 1))) {
            return true;
        }
        return helper7(node.left, arr, index + 1) || helper7(node.right, arr, index + 1);
    }

    public void DFSUsingStack(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode removed = stack.pop();
            System.out.print(removed.val + " ");
            if (removed.right != null) {
                stack.push(removed.right);
            }
            if (removed.left != null) {
                stack.push(removed.left);
            }
        }
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

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
