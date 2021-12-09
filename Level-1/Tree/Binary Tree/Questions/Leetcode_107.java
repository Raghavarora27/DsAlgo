package questions;

import java.util.*;

public class Leetcode_107 {
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null)
                return new ArrayList<>();

            LinkedList<TreeNode> que = new LinkedList<>();
            que.add(root);

            List<List<Integer>> res = new ArrayList<>();

            while (que.size() != 0) {
                int size = que.size();

                List<Integer> ans = new ArrayList<>();
                while (size-- > 0) {
                    TreeNode rn = que.removeFirst();
                    ans.add(rn.val);

                    if (rn.left != null)
                        que.addLast(rn.left);
                    if (rn.right != null)
                        que.addLast(rn.right);
                }
                res.add(0, ans);
            }
            // Collections.reverse(res);
            // you can reverse the arrayList or you can add the ans at 0 index of res
            // arraylist
            return res;
        }
    }
}