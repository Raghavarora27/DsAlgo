package Questions;

import java.util.*;

public class Leetocde_863 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // TC : O(n) SC : O(n)
    class Solution {
        public List<Integer> distanceK(TreeNode node, TreeNode target, int k) {
            List<TreeNode> ans = new ArrayList<>();
            nodeToRootPath(node, target.val, ans);

            List<Integer> Myans = new ArrayList<>();

            TreeNode block = null;
            for (int i = 0; i < ans.size(); i++) {
                KLevelsDown(ans.get(i), k - i, block, Myans);
                block = ans.get(i);
            }
            return Myans;
        }

        public boolean nodeToRootPath(TreeNode node, int data, List<TreeNode> ans) {
            if (node == null)
                return false;

            if (node.val == data) {
                ans.add(node);
                return true;
            }

            boolean res = nodeToRootPath(node.left, data, ans) || nodeToRootPath(node.right, data, ans);
            if (res)
                ans.add(node);

            return res;
        }

        public void KLevelsDown(TreeNode node, int k, TreeNode block, List<Integer> ans) {
            if (node == null || k < 0 || node == block)
                return;

            if (k == 0) {
                ans.add(node.val);
                return;
            }

            KLevelsDown(node.left, k - 1, block, ans);
            KLevelsDown(node.right, k - 1, block, ans);
        }
    }

    // TC : O(n) SC : O(1)
    class Solution2 {
        public List<Integer> distanceK(TreeNode node, TreeNode target, int k) {
            List<Integer> ans = new ArrayList<>();
            kaway2(node, target.val, k, ans);

            return ans;
        }

        public int kaway2(TreeNode node, int data, int k, List<Integer> ans) {
            if (node == null)
                return -1;

            if (node.val == data) {
                KLevelsDown(node, k, null, ans);
                return 1;
            }

            int ld = kaway2(node.left, data, k, ans);
            if (ld != -1) {
                KLevelsDown(node, k - ld, node.left, ans);
                return ld + 1;
            }

            int rd = kaway2(node.right, data, k, ans);
            if (rd != -1) {
                KLevelsDown(node, k - rd, node.right, ans);
                return rd + 1;
            }

            return -1;
        }

        public void KLevelsDown(TreeNode node, int k, TreeNode block, List<Integer> ans) {
            if (node == null || k < 0 || node == block)
                return;

            if (k == 0) {
                ans.add(node.val);
                return;
            }

            KLevelsDown(node.left, k - 1, block, ans);
            KLevelsDown(node.right, k - 1, block, ans);
        }
    }
}
