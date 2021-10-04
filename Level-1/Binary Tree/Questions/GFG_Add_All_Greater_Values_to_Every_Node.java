package Questions;

// https://practice.geeksforgeeks.org/problems/add-all-greater-values-to-every-node-in-a-bst/1#
public class GFG_Add_All_Greater_Values_to_Every_Node {
    class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    class Solution {

        // modify the BST and return its root
        public void modify_(Node root, int[] arr) {
            if (root == null)
                return;

            modify_(root.right, arr);
            root.data += arr[0];
            arr[0] = root.data;
            modify_(root.left, arr);
        }

        public Node modify(Node root) {
            int[] arr = new int[1];
            modify_(root, arr);
            return root;
        }

    }

}
