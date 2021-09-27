package Questions;

import java.util.*;

public class Leetcode_144 {
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            preorder(root, ans);
            return ans;
        }

        public void preorder(TreeNode root, List<Integer> ans) {
            if (root == null)
                return;

            ans.add(root.val);
            preorder(root.left, ans);
            preorder(root.right, ans);
        }
    }

    class Solution1 {
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null)
                return new ArrayList<>();

            List<Integer> ans = new ArrayList<>();

            ans.add(root.val);

            List<Integer> left = preorderTraversal(root.left);
            for (int ele : left) // ans.addAll(left)
                ans.add(ele);

            List<Integer> right = preorderTraversal(root.right);
            for (int ele : right) // ans.addAll(right)
                ans.add(ele);
            return ans;
        }
    }
}
