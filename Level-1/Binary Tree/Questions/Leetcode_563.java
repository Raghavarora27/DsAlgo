package Questions;

public class Leetcode_563 {
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
        public int findTilt(TreeNode root) {
            return tilt_(root).tiltSF_;
        }

        public class tiltPair_ {
            int tiltSF_ = 0;
            int sum_ = 0;
        }

        public tiltPair_ tilt_(TreeNode root) {
            if (root == null)
                return new tiltPair_();

            tiltPair_ left = tilt_(root.left);
            tiltPair_ right = tilt_(root.right);

            tiltPair_ myAns = new tiltPair_();

            myAns.tiltSF_ = left.tiltSF_ + right.tiltSF_ + Math.abs(left.sum_ - right.sum_);
            myAns.sum_ = left.sum_ + right.sum_ + root.val;

            return myAns;
        }
    }
}
