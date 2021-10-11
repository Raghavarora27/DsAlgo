package questions;

import java.util.*;

public class Leetcode_590 {
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
        public List<Integer> postorder(Node root) {
            ArrayList<Integer> ans = new ArrayList<>();
            postorder(root, ans);
            return ans;
        }

        public void postorder(Node root, ArrayList<Integer> ans) {
            if (root == null)
                return;
            for (Node child : root.children)
                postorder(child, ans);
            ans.add(root.val);
        }
    }
}
