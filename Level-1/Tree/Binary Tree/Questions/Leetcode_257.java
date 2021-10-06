package Questions;
public class Leetcode_257 {
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

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ans = new ArrayList<>();
            TreePath(root, ans, "");
            return ans;
        }

        public void TreePath(TreeNode root, List<String> ans, String str) {
            if (root == null)
                return;

            if (str != "") {
                str = str + "->" + root.val;
            } else {
                str += root.val;
            }

            if (root.left == null && root.right == null) {
                ans.add(str);
                str = "";
                return;
            }

            if (root.left != null)
                TreePath(root.left, ans, str);
            if (root.right != null)
                TreePath(root.right, ans, str);
        }
    }
}
