package Questions;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        public List<TreeNode> nodeToRootPath_(TreeNode node, int data) {
            if (node == null)
                return null;

            if (node.val == data) {
                List<TreeNode> list = new ArrayList<>();
                list.add(node);
                return list;
            }

            List<TreeNode> left = nodeToRootPath_(node.left, data);
            if (left != null) {
                left.add(node);
                return left;
            }

            List<TreeNode> right = nodeToRootPath_(node.right, data);
            if (right != null) {
                right.add(node);
                return right;
            }

            return null;
        }

        public List<TreeNode> nodeToRootPath(TreeNode node, int data) {
            List<TreeNode> ans = nodeToRootPath_(node, data);
            return ans != null ? ans : new ArrayList<>();
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> list1 = nodeToRootPath(root, p.val);
            List<TreeNode> list2 = nodeToRootPath(root, q.val);

            int i = list1.size() - 1;
            int j = list2.size() - 1;

            TreeNode LCA = null;
            while (i >= 0 && j >= 0) {
                if (list1.get(i) != list2.get(j))
                    break;
                LCA = list2.get(j);
                i--;
                j--;

            }

            return LCA;
        }

    }
}
