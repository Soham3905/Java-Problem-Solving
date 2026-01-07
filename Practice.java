
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }

    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int diff = points[i][0] - points[i - 1][0];
            if (result < diff) {
                result = diff;
            }
        }
        return result;
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
}
