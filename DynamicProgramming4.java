
import java.util.HashMap;

public class DynamicProgramming4 {

    public static void main(String[] args) {

    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        // TreeNode() {
        // }
        // TreeNode(int val) {
        //     this.val = val;
        // }
        // TreeNode(int val, TreeNode left, TreeNode right) {
        //     this.val = val;
        //     this.left = left;
        //     this.right = right;
        // }
    }

    public int height(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int left_height = height(root.left, map);
        int right_height = height(root.right, map);
        map.put(root, 1 + Math.max(left_height, right_height));
        return map.get(root);
    }

    public int diameter(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }

        int diameter = height(root.left, map) + height(root.right, map);
        int left_dia = diameter(root.left, map);
        int right_dia = diameter(root.right, map);
        return Math.max(diameter, Math.max(left_dia, right_dia));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return diameter(root, map);
    }

    //    int diameter = 0;
    // public int diameterOfBinaryTree(TreeNode root) {
    //     height(root);
    //     return diameter;
    // }
    // public int height(TreeNode node) {
    //     if (node == null) {
    //         return 0;
    //     }
    //     int leftHeight = height(node.left);
    //     int rightHeight = height(node.right);
    //     int path = leftHeight + rightHeight;
    //     diameter = Math.max(path, diameter);
    //     return 1 + Math.max(leftHeight, rightHeight);
    // }
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = height(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        lineSum(root);
        return max;
    }

    private int lineSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_lineSum = lineSum(root.left);
        left_lineSum = Math.max(0, left_lineSum);
        int right_lineSum = lineSum(root.right);
        right_lineSum = Math.max(0, right_lineSum);
        int pathSum = root.val + left_lineSum + right_lineSum;
        max = Math.max(max, pathSum);
        return root.val + Math.max(left_lineSum, right_lineSum);
    }

    public int numTrees(int n) {
        if(n<=1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
