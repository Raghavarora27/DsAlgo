package Questions;

public class Leetcode_1038 {
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
        public TreeNode bstToGst(TreeNode root) {
            int[] arr = new int[1];
            BST_GST(root, arr);
            return root;
        }

        public void BST_GST(TreeNode root, int[] arr) {
            if (root == null)
                return;

            BST_GST(root.right, arr);

            root.val += arr[0];
            arr[0] = root.val;

            BST_GST(root.left, arr);
        }
    }
}
