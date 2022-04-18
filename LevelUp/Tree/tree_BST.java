import java.util.ArrayList;
import java.util.LinkedList;

public class tree_BST {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int size(TreeNode root) {
        return root == null ? 0 : size(root.left) + size(root.right) + 1;
    }

    public static int height(TreeNode root) {
        return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int maximum(TreeNode root) {
        TreeNode node = root;
        while (node.right != null)
            node = node.right;

        return node.val;
    }

    public static int minimum(TreeNode root) {
        TreeNode curr = root;
        while (curr.left != null)
            curr = curr.left;

        return curr.val;
    }

    public static boolean find(TreeNode root, int data) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.val == data)
                return true;
            else if (curr.val > data)
                curr = curr.left;
            else
                curr = curr.right;
        }

        return false;
    }

    // TC : O(n)
    public static ArrayList<TreeNode> NodeToRootPath(TreeNode root, int data) {
        TreeNode curr = root;
        ArrayList<TreeNode> ans = new ArrayList<>();
        while (curr != null) {
            ans.add(curr);
            if (curr.val == data)
                break;
            else if (curr.val > data)
                curr = curr.left;
            else
                curr = curr.right;
        }

        return ans;
    }

    public static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root, LCANode = null;
        while (curr != null) {
            if (curr.val < p.val && curr.val < q.val)
                curr = curr.right;
            else if (curr.val > p.val && curr.val > p.val)
                curr = curr.left;
            else {
                LCANode = curr;
                break;
            }
        }
        return (LCANode != null && find(LCANode, p.val) && find(LCANode, q.val)) ? LCANode : null;
        // checking value exist in BST or not
        // find me LCA as root pass kiya as root se LCA tak phele hi travel karchuke h
        // aab uske aage hi find karna h data
    }

    // Morris Inorder Traversal
    // TC: O(n) SC: O(1)
    public static ArrayList<Integer> MorrisInorderTraversal(TreeNode root) {
        TreeNode curr = root;
        ArrayList<Integer> ans = new ArrayList<>();

        while (curr != null) {
            TreeNode left = curr.left;
            if (left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if (rightMostNode.right == null) { // thread creation block
                    rightMostNode.right = curr; // thread is created
                    curr = curr.left;
                } else { // thread destroy block
                    rightMostNode.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return ans;
    }

    public static TreeNode getRightMostNode(TreeNode node, TreeNode curr) {
        while (node.right != null && node.right != curr) {
            node = node.right;
        }

        return node;
    }

    public static ArrayList<Integer> MorrisPreorderTraversal(TreeNode root) {
        TreeNode curr = root;
        ArrayList<Integer> ans = new ArrayList<>();

        while (curr != null) {
            TreeNode left = curr.left;
            if (left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if (rightMostNode.right == null) { // thread creation block
                    rightMostNode.right = curr; // thread is created
                    ans.add(curr.val);
                    curr = curr.left;
                } else { // thread destroy block
                    rightMostNode.right = null;
                    curr = curr.right;
                }
            }
        }

        return ans;
    }

    // using Morris Traversal
    // TC : O(n) SC : O(1)
    public boolean isValidBST(TreeNode root) {
        TreeNode curr = root;
        long prev = -(long) 1e13;

        while (curr != null) {
            TreeNode left = curr.left;
            if (left == null) {
                if (prev >= curr.val)
                    return false;
                prev = curr.val;
                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if (rightMostNode.right == null) { // thread creation block
                    rightMostNode.right = curr; // thread is created
                    curr = curr.left;
                } else { // thread destroy block
                    rightMostNode.right = null;

                    if (prev >= curr.val)
                        return false;
                    prev = curr.val;
                    curr = curr.right;
                }
            }
        }

        return true;
    }

    // TC : O(n) SC : O(n)
    public static boolean isValidBST_2(TreeNode root) {
        LinkedList<TreeNode> st = new LinkedList<>();
        insertAllLeft(root, st);
        long prev = -(long) 1e13;

        while (st.size() != 0) {
            TreeNode rnode = st.removeFirst();

            if (prev >= rnode.val)
                return false;
            prev = rnode.val;

            insertAllLeft(rnode.right, st);
        }

        return true;
    }

    public static void insertAllLeft(TreeNode node, LinkedList<TreeNode> st) {
        while (node != null) {
            st.addFirst(node);
            node = node.left;
        }
    }

    public boolean isValidBST_3(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null)
            return true;
        if (min != null && root.val <= min.val)
            return false;
        if (max != null && root.val >= max.val)
            return false;
        return isValidBST_3(root.left, min, root) && isValidBST_3(root.right, root, max);
    }

    // 173. Binary Search Tree Iterator
    class BSTIterator {

        LinkedList<TreeNode> st = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            insertAllLeft(root, st);
        }

        private void insertAllLeft(TreeNode node, LinkedList<TreeNode> st) {
            while (node != null) {
                st.addFirst(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode rn = st.removeFirst();
            insertAllLeft(rn.right, st);
            return rn.val;
        }

        public boolean hasNext() {
            return st.size() != 0;
        }
    }

    // 230. Kth Smallest Element in a BST
    // using morris Inorder Traversal
    // TC : O(n) SC : O(1)
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        int rv = -1;

        while (curr != null) {
            TreeNode left = curr.left;
            if (left == null) {
                if (--k == 0)
                    rv = curr.val;
                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if (rightMostNode.right == null) { // thread creation block
                    rightMostNode.right = curr; // thread is created
                    curr = curr.left;
                } else { // thread destroy block
                    rightMostNode.right = null;
                    if (--k == 0)
                        rv = curr.val;
                    curr = curr.right;
                }
            }
        }

        return rv;
    }

    // kth largest do it on your own -- reverse morris traversal (from right)
    // convert BST into Doubly LL
    public static TreeNode CDLL(TreeNode root) {
        TreeNode dummy = new TreeNode(-1), curr = root, prev = dummy;
        while (curr != null) {
            TreeNode left = curr.left;
            if (left == null) {
                prev.right = curr;
                curr.left = prev;
                prev = prev.right;

                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if (rightMostNode.right == null) {
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else {
                    rightMostNode.right = null;

                    prev.right = curr;
                    curr.left = prev;
                    prev = prev.right;

                    curr = curr.right;
                }
            }
        }

        TreeNode head = dummy.right;
        dummy.right = head.left = null;

        // for circular doubly LL
        head.left = prev;
        prev.right = head;

        return head;
    }

}