package Questions;

import java.util.List;

public class Leetcode_559 {
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
    }

    class Solution {
        public int maxDepth(Node root) {
            if (root == null)
                return 0;
            int h = 0;
            for (Node child : root.children)
                h = Math.max(maxDepth(child), h);

            return h + 1;
        }
    }
}
