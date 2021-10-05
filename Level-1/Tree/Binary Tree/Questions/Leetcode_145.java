package Questions;

import java.util.*;

public class Leetcode_145 {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null)
                return new ArrayList<>();

            List<Integer> ans = new ArrayList<>();

            List<Integer> left = postorderTraversal(root.left);
            for (int ele : left) // ans.addAll(left)
                ans.add(ele);

            List<Integer> right = postorderTraversal(root.right);
            for (int ele : right) // ans.addAll(right)
                ans.add(ele);

            ans.add(root.val);

            return ans;
        }
    }
}
