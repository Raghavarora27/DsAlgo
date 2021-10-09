package Questions;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Leetcode_102 {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            LinkedList<TreeNode> que = new LinkedList<>(); // removeFirst, addLast
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null)
                return ans;
            que.addLast(root);

            // int level = 0;
            while (que.size() != 0) {
                int size = que.size();
                List<Integer> res = new ArrayList<>();
                while (size-- > 0) {
                    TreeNode rn = que.removeFirst();
                    res.add(rn.val);

                    if (rn.left != null)
                        que.addLast(rn.left);
                    if (rn.right != null)
                        que.addLast(rn.right);
                }
                ans.add(res);
            }
            return ans;
        }
    }
}
