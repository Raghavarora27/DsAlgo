package Questions;

public class Leetcode_98 {
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
        TreeNode prev = null;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            if (!isValidBST(root.left))
                return false;

            if (prev != null && prev.val >= root.val)
                return false;
            prev = root;

            if (!isValidBST(root.right))
                return false;

            return true;
        }
    }

    /// 2nd Method using class

    class Solution2 {
        public boolean isValidBST(TreeNode root) {
            isBSTPair ans = isBST_02(root);
            return ans.isBST;
        }

        public class isBSTPair {
            boolean isBST = true;
            long maxEle = -(long) 1e13;
            long minEle = (long) 1e13;
        }

        public isBSTPair isBST_02(TreeNode node) {
            if (node == null)
                return new isBSTPair();

            isBSTPair left = isBST_02(node.left);
            if (!left.isBST)
                return left;

            isBSTPair right = isBST_02(node.right);
            if (!right.isBST)
                return right;

            isBSTPair self = new isBSTPair();
            self.isBST = false;

            if (left.maxEle < node.val && right.minEle > node.val) {
                self.maxEle = Math.max(right.maxEle, node.val);
                self.minEle = Math.min(left.minEle, node.val);
                self.isBST = true;
            }

            return self;
        }
    }

    // 3rd method
    class Solution3 {
        public boolean isValidBST(TreeNode root) {
            return BST(root, null, null);
        }

        public boolean BST(TreeNode root, TreeNode min, TreeNode max) {
            if (root == null)
                return true;
            if (min != null && root.val <= min.val)
                return false;
            if (max != null && root.val >= max.val)
                return false;
            return BST(root.left, min, root) && BST(root.right, root, max);
        }
    }
}
