package Questions;

public class Leetcode_429 {
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
        public List<List<Integer>> levelOrder(Node root) {
            LinkedList<Node> que = new LinkedList<>(); // removeFirst, addLast
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null)
                return ans;
            que.addLast(root);

            int level = 0;
            while (que.size() != 0) {
                int size = que.size();
                List<Integer> res = new ArrayList<>();
                while (size-- > 0) {
                    Node rn = que.removeFirst();
                    res.add(rn.val);

                    for (Node child : rn.children) {
                        que.addLast(child);
                    }

                }
                ans.add(res);
            }
            return ans;

        }
    }
}
