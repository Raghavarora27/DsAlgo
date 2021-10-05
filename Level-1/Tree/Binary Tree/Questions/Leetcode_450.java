package Questions;

public class Leetcode_450 {
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
        public int minimum(TreeNode node) {
            while (node.left != null)
                node = node.left;
            return node.val;
        }

        public TreeNode deleteNode(TreeNode node, int val) {
            if (node == null)
                return null;

            if (node.val < val)
                node.right = deleteNode(node.right, val);
            else if (node.val > val)
                node.left = deleteNode(node.left, val);
            else {
                if (node.left == null || node.right == null)
                    return node.left != null ? node.left : node.right;
                int minEle = minimum(node.right);
                node.val = minEle;

                node.right = deleteNode(node.right, minEle);
            }

            return node;
        }
    }
}
