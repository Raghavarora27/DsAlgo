package questions;

public class Leetcode_589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    class Solution {
        public List<Integer> preorder(Node root) {
            ArrayList<Integer> ans = new ArrayList<>();
            preorderTraversal(root, ans);
            return ans;
        }

        public void preorderTraversal(Node root, ArrayList<Integer> ans) {
            if (root == null)
                return;
            ans.add(root.val);
            for (Node child : root.children)
                preorderTraversal(child, ans);
        }
    }
}
