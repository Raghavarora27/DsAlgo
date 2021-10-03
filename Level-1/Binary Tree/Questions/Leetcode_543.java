package Questions;

public class Leetcode_543 {
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

    // O(N*N)
    class Solution1 {

        public int height(TreeNode root) {
            return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
        }

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null)
                return 0;

            int ld = diameterOfBinaryTree(root.left);
            int rd = diameterOfBinaryTree(root.right);

            int lh = height(root.left);
            int rh = height(root.right);

            return Math.max(Math.max(ld, rd), lh + rh + 2);
        }
    }

    // O(N)
    class Solution2 {

        public int diameterOfBinaryTree(TreeNode root) {
            return diameterOfBinaryTree_(root)[0];
        }

        // {diameter, height}
        public int[] diameterOfBinaryTree_(TreeNode root) {
            if (root == null)
                return new int[] { 0, -1 };

            int[] ld = diameterOfBinaryTree_(root.left);
            int[] rd = diameterOfBinaryTree_(root.right);

            int[] myAns = new int[2];

            myAns[0] = Math.max(Math.max(ld[0], rd[0]), ld[1] + rd[1] + 2);
            myAns[1] = Math.max(ld[1], rd[1]) + 1;
            return myAns;
        }
    }

    // O(N)
    class Solution3 {

        public int diameterOfBinaryTree(TreeNode root) {
            diameterOfBinaryTree_(root);
            return diameter;
        }

        int diameter = 0;

        public int diameterOfBinaryTree_(TreeNode root) {
            if (root == null)
                return -1;

            int ld = diameterOfBinaryTree_(root.left);
            int rd = diameterOfBinaryTree_(root.right);

            diameter = Math.max(diameter, ld + rd + 2);

            return Math.max(ld, rd) + 1;
        }
    }
}
