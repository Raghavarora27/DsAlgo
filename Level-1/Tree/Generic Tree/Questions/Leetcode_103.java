package questions;

import java.util.*;

public class Leetcode_103 {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null)
                return ans;
            LinkedList<TreeNode> que = new LinkedList<>(); // removeFirst, addLast
            LinkedList<TreeNode> st = new LinkedList<>(); // removeFirst, addFirst

            que.addLast(root);
            int level = 0;

            while (que.size() != 0) {
                int size = que.size();
                List<Integer> smallAns = new ArrayList<>();
                while (size-- > 0) {
                    TreeNode rn = que.removeFirst();
                    smallAns.add(rn.val);

                    if (level % 2 == 0) {
                        if (rn.left != null)
                            st.addFirst(rn.left);
                        if (rn.right != null)
                            st.addFirst(rn.right);
                    } else {
                        if (rn.right != null)
                            st.addFirst(rn.right);
                        if (rn.left != null)
                            st.addFirst(rn.left);
                    }
                }
                level++;
                ans.add(smallAns);
                LinkedList<TreeNode> temp = que;
                que = st;
                st = temp;
            }

            return ans;

        }
    }
}
