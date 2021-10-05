package Questions;

// https://practice.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1#
public class GFG_Count_leaves {
    class Node {
        int data;
        Node left, right;
    }

    class Tree {
        int countLeaves(Node node) {
            if (node == null)
                return 0;
            if (node.left == null && node.right == null)
                return 1;
            int left = countLeaves(node.left);
            int right = countLeaves(node.right);
            return left + right;
        }
    }
}
