
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    long max = Integer.MIN_VALUE;

    public int maxProduct(TreeNode root) {
        int sum = treeSum(root);
        dfs(root,sum);
        return (int)(max % 1_000_000_007);
    }

    public long dfs(TreeNode root,int sum) {
        if (root==null) {
            return 0;
        }
        long left = dfs(root.left,sum);
        long right = dfs(root.right,sum);
        long currSum = left + right + root.val;
        max = Math.max((sum - currSum) * currSum, max);
        return currSum;
    }

    public int treeSum(TreeNode root) {
       if (root == null) {
           return 0;
       }
       return root.val + treeSum(root.left) + treeSum(root.right);
    }

    class Pair{

        TreeNode node;
        int depth;

        public Pair(TreeNode node,int depth) {
            this.node = node;
            this.depth = depth;
        }
        
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
       return helper(root).node;
    }

    public Pair helper(TreeNode root){
        if(root == null){
            return new Pair(root,0);
        }

        Pair left = helper(root.left);
        Pair right = helper(root.right);

        if (left.depth == right.depth) {
            return new Pair(root, left.depth+1);
        }else if (left.depth > right.depth) {
            return new Pair(root, left.depth+1);
        }else {
            return new Pair(root.right, right.depth+1);
        }
    }

}
