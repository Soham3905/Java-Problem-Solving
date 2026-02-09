
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
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return solve(0,list.size()-1,root,list);
    }

    public TreeNode solve(int left, int right, TreeNode root,ArrayList<Integer> list){
        if (left > right) {
            return null;
        }
        int mid = left + (right-left)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = solve(left, mid-1, root, list);
        node.right = solve(mid+1, right, root, list);
        return node;
    }

    public void inOrder(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

}

}
