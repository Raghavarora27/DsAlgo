import java.util.LinkedList;

public class tree_Construction {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode DLLToBST(TreeNode head) {
        if (head == null || head.right == null)
            return head;

        TreeNode midNode = getMidNode(head);
        TreeNode prev = midNode.left, forw = midNode.right;

        midNode.left = midNode.right = forw.left = null;
        if (prev != null)
            prev.right = null;

        TreeNode root = midNode, leftHead = (prev != null ? head : null), rightHead = forw;

        root.left = DLLToBST(leftHead);
        root.right = DLLToBST(rightHead);

        return root;
    }

    public static TreeNode getMidNode(TreeNode head) {
        if (head == null || head.right == null)
            return head;

        TreeNode slow = head, fast = head;
        while (fast.right != null && fast.right.right != null) {
            slow = slow.right;
            fast = fast.right;
        }

        return slow;
    }

    public static TreeNode MergeSort(TreeNode head) {
        if (head == null || head.right == null)
            return head;

        TreeNode midNode = getMidNode(head);
        TreeNode forwHead = midNode.right;
        forwHead.left = midNode.right = null;

        return mergeTwoSortedDoublyLL(MergeSort(head), MergeSort(forwHead));
    }

    public static TreeNode mergeTwoSortedDoublyLL(TreeNode l1, TreeNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        TreeNode dummy = new TreeNode(-1), prev = dummy;
        TreeNode c1 = l1, c2 = l2;
        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                prev.right = c1;
                c1.left = prev;
                c1 = c1.right;
            } else {
                prev.right = c2;
                c2.left = prev;
                c2 = c2.right;
            }
            prev = prev.right;
        }

        if (c1 != null) {
            prev.right = c1;
            c1.left = prev;
        } else {
            prev.right = c2;
            c2.left = prev;
        }

        TreeNode head = dummy.right;
        dummy.right = head.left = null;

        return head;
    }

    public static TreeNode DLL(TreeNode root) {
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

        return head;
    }

    public static TreeNode getRightMostNode(TreeNode node, TreeNode curr) {
        while (node.right != null && node.right != curr) {
            node = node.right;
        }

        return node;
    }

    public static void Display(TreeNode node) {
        if (node == null)
            return;

        String str = "";
        str += ((node.left != null ? Integer.toString(node.left.val) : "."));
        str += ("->" + Integer.toString(node.val) + "<-");
        str += ((node.right != null ? Integer.toString(node.right.val) : "."));

        System.out.println(str);
        Display(node.left);
        Display(node.right);
    }

    public static TreeNode BTToBST(TreeNode root) {
        if (root == null)
            return root;

        TreeNode head = DLL(root);
        head = MergeSort(head);
        root = DLLToBST(head);

        return root;
    }

    public static TreeNode ConstructionFromInOrder(int[] inorder, int si, int ei) {
        if (si > ei)
            return null;

        int mid = (si + ei) / 2;
        TreeNode root = new TreeNode(inorder[mid]);

        root.left = ConstructionFromInOrder(inorder, si, mid - 1);
        root.right = ConstructionFromInOrder(inorder, mid + 1, ei);

        return root;
    }

    public static TreeNode ConstructionFromInorder(int[] inorder) {
        return ConstructionFromInOrder(inorder, 0, inorder.length - 1);
    }

    public static TreeNode BSTFromPreorder(int[] preorder, int lr, int rr, int[] idx) {
        int i = idx[0];
        if (i >= preorder.length || preorder[i] < lr || preorder[i] > rr)
            return null;

        TreeNode root = new TreeNode(preorder[i]);
        idx[0]++;

        root.left = BSTFromPreorder(preorder, lr, root.val, idx);
        root.right = BSTFromPreorder(preorder, root.val, rr, idx);

        return root;
    }

    public static TreeNode BSTFromPreorder(int[] preorder) {
        int[] idx = { 0 };
        return BSTFromPreorder(preorder, -(int) 1e9, (int) 1e9, idx);
    }

    public static TreeNode BSTFromPostorder(int[] postorder, int lr, int rr, int[] idx) {
        int i = idx[0];
        if (i <= -1 || postorder[i] < lr || postorder[i] > rr)
            return null;

        TreeNode root = new TreeNode(postorder[i]);
        idx[0]--;

        root.right = BSTFromPostorder(postorder, root.val, rr, idx);
        root.left = BSTFromPostorder(postorder, lr, root.val, idx);

        return root;
    }

    public static TreeNode BSTFromPostorder(int[] postorder) {
        int[] idx = { postorder.length - 1 };
        return BSTFromPostorder(postorder, -(int) 1e9, (int) 1e9, idx);
    }

    public class Codec {

        // Encodes a tree to a single string.
        public void serialize(TreeNode root, StringBuilder sb) {
            if (root == null)
                return;

            sb.append(root.val + " ");

            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] arr = data.split(" ");
            int[] preorder = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                preorder[i] = Integer.parseInt(arr[i]);
            }

            int[] idx = new int[1];
            return BSTFromPreorder(preorder, -(int) 1e9, (int) 1e9, idx);
        }
    }

    // TC: O(n^2)
    // if you want to optimise you can use map, Iterate through the inorder array
    // and map index with the element,then you can avoid the while loop
    // It will save some time but takes some space
    public static TreeNode buildTree(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (psi > pei)
            return null;

        int idx = isi;
        while (inorder[idx] != preorder[psi])
            idx++;

        int tnel = idx - isi; // total number of element on left side
        TreeNode root = new TreeNode(preorder[psi]);

        root.left = buildTree(preorder, psi + 1, psi + tnel, inorder, isi, idx - 1);
        root.right = buildTree(preorder, psi + tnel + 1, pei, inorder, idx + 1, iei);

        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildTree(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    public static TreeNode buildTreeFromPostorder(int[] postorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (psi > pei)
            return null;

        int idx = isi;
        while (inorder[idx] != postorder[pei])
            idx++;

        int tnel = idx - isi; // total number of element on left side
        TreeNode root = new TreeNode(postorder[pei]);

        root.left = buildTreeFromPostorder(postorder, psi, psi + tnel - 1, inorder, isi, idx - 1);
        root.right = buildTreeFromPostorder(postorder, psi + tnel, pei - 1, inorder, idx + 1, iei);

        return root;
    }

    public static TreeNode buildTreeFromPostorder(int[] postorder, int[] inorder) {
        int n = postorder.length;
        return buildTreeFromPostorder(postorder, 0, n - 1, inorder, 0, n - 1);
    }

    public static TreeNode buildTreeFromPrePost(int[] postorder, int ppsi, int ppei, int[] preorder, int psi, int pei) {
        if (psi > pei)
            return null;

        TreeNode root = new TreeNode(preorder[psi]);
        if (psi == pei)
            return root;

        int idx = ppsi;
        while (postorder[idx] != preorder[psi + 1])
            idx++;

        int tnel = idx - ppsi + 1; // total number of element on left side

        root.left = buildTreeFromPrePost(postorder, ppsi, ppsi + tnel - 1, preorder, psi + 1, psi + tnel);
        root.right = buildTreeFromPrePost(postorder, ppsi + tnel, pei - 1, preorder, psi + tnel + 1, pei);

        return root;
    }

    public static TreeNode buildTreeFromPrePost(int[] postorder, int[] preorder) {
        int n = postorder.length;
        return buildTreeFromPrePost(postorder, 0, n - 1, preorder, 0, n - 1);
    }

    // 297. Serialize and Deserialize Binary Tree
    // Approach - 1
    public class CodecBinaryTree {

        public String serialize(TreeNode root) {
            if (root == null)
                return "";
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        public void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("# ");
                return;
            }

            sb.append(root.val + " ");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        int idx = 0;

        public TreeNode deserialize(String[] arr) {
            if (idx >= arr.length || arr[idx].equals("#")) {
                idx++;
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(arr[idx++]));
            root.left = deserialize(arr);
            root.right = deserialize(arr);

            return root;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String str) {
            if (str.length() == 0)
                return null;
            String[] arr = str.split(" ");
            return deserialize(arr);
        }
    }

    // Approach - 2
    // using Level-order Traversal
    public class CodecBinaryTree_02 {

        public String serialize(TreeNode root) {
            if (root == null)
                return "";
            StringBuilder sb = new StringBuilder();
            LinkedList<TreeNode> que = new LinkedList<>();
            que.addLast(root);

            while (que.size() != 0) {
                TreeNode rnode = que.removeFirst();
                sb.append((rnode != null ? rnode.val : "#") + " ");

                if (rnode == null)
                    continue;

                que.addLast(rnode.left);
                que.addLast(rnode.right);
            }

            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            if (data.length() == 0)
                return null;

            String[] arr = data.split(" ");
            LinkedList<TreeNode> que = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
            que.addLast(root);

            int idx = 1;
            while (que.size() != 0) {
                TreeNode rnode = que.removeFirst();

                if (!arr[idx].equals("#")) {
                    TreeNode leftChild = new TreeNode(Integer.parseInt(arr[idx]));
                    rnode.left = leftChild;
                    que.addLast(leftChild);
                }
                idx++;

                if (!arr[idx].equals("#")) {
                    TreeNode rightChild = new TreeNode(Integer.parseInt(arr[idx]));
                    rnode.right = rightChild;
                    que.addLast(rightChild);
                }
                idx++;

            }

            return root;
        }
    }

    // 110. Balanced Binary Tree
    public class BSTPair {
        int h = -1;
        boolean isBal = true;
    }

    public BSTPair isBalanced_(TreeNode root) {
        if (root == null)
            return new BSTPair();

        BSTPair lp = isBalanced_(root.left);
        BSTPair rp = isBalanced_(root.right);

        BSTPair myPair = new BSTPair();
        myPair.isBal = lp.isBal && rp.isBal;
        if (myPair.isBal && Math.abs(lp.h - rp.h) < 2)
            myPair.h = Math.max(lp.h, rp.h) + 1;
        else
            myPair.isBal = false;

        return myPair;
    }

    public boolean isBalanced(TreeNode root) {
        return isBalanced_(root).isBal;
    }

    // Largest BST SUbtree
    public static class BSTPair_ {
        boolean isBST = true;
        int min = (int) 1e9;
        int max = -(int) 1e9;

        int size = 0;
        TreeNode largestRoot = null;
    }

    public static BSTPair_ largestBST_(TreeNode root) {
        if (root == null) {
            return new BSTPair_();
        }

        BSTPair_ lp = largestBST_(root.left);
        BSTPair_ rp = largestBST_(root.right);

        BSTPair_ myPair = new BSTPair_();
        myPair.isBST = false;

        if (lp.isBST && rp.isBST && lp.max < root.val && root.val < rp.min) {
            myPair.isBST = true;
            myPair.min = Math.min(lp.min, root.val);
            myPair.max = Math.max(rp.max, root.val);
            myPair.size = lp.size + rp.size + 1;
            myPair.largestRoot = root;
        } else {
            if (lp.size > rp.size) {
                myPair.size = lp.size;
                myPair.largestRoot = lp.largestRoot;
            } else {
                myPair.size = rp.size;
                myPair.largestRoot = rp.largestRoot;
            }
        }

        return myPair;
    }

    public static TreeNode largestBST(TreeNode root) {
        return largestBST_(root).largestRoot;
    }

    // pred and successor in Binary Tree
    public static void findPreSuc(TreeNode root, int key) {
        if (root == null)
            return;

        TreeNode curr = root;
        TreeNode prev = null, pred = null, succ = null;
        while (curr != null) {
            TreeNode left = curr.left;
            if (left == null) {
                if (curr.val == key) {
                    pred = prev;
                }

                if (prev != null && prev.val == key) {
                    succ = curr;
                }

                prev = curr;
                curr = curr.right;
            } else {
                TreeNode RightMostNode = getRightMostNode(left, curr);
                if (RightMostNode.right == null) {
                    RightMostNode.right = curr;
                    curr = curr.left;
                } else {
                    RightMostNode.right = null;
                    if (curr.val == key) {
                        pred = prev;
                    }

                    if (prev != null && prev.val == key) {
                        succ = curr;
                    }

                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        System.out.println(pred + " " + succ);
    }

    // BST predeccesor and successor
    // successor --- right ka leftmost
    // pred --- left ka rightmost
    // TC : O(logn) SC : O(1)
    // same for ceil and floor
    public static void predSucc(TreeNode root, int data) {
        TreeNode curr = root, succ = null, pred = null;

        while (curr != null) {
            if (curr.val == data) {
                TreeNode leftMost = getLeftMost(curr.right);
                succ = leftMost != null ? leftMost : succ;

                TreeNode RightMost = getRightMost(curr.left);
                pred = RightMost != null ? RightMost : pred;
                break;
            } else if (curr.val > data) {
                pred = curr;
                curr = curr.right;
            } else {
                succ = curr;
                curr = curr.left;
            }
        }
    }

    public static TreeNode getLeftMost(TreeNode curr) {
        if (curr == null)
            return null;

        while (curr.left != null)
            curr = curr.left;

        return curr;
    }

    public static TreeNode getRightMost(TreeNode curr) {
        if (curr == null)
            return null;

        while (curr.right != null)
            curr = curr.right;

        return curr;
    }

    // 701. Insert into a Binary Search Tree
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);

        return root;
    }

    // 450. Delete Node in a BST
    // 4 cases -- 1. leaf (no child) 2. One child(left)
    // 3. One child(right) 4. both child
    // TC : O(logn)
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null || root.right == null) {
                TreeNode rNode = root.left != null ? root.left : root.right;
                root.left = root.right = null;
                return rNode;
            }

            int minELe = getMin(root.right);
            root.val = minELe;

            root.right = deleteNode(root.right, minELe);
        }

        return root;
    }

    public static int getMin(TreeNode curr) {
        while (curr.left != null)
            curr = curr.left;

        return curr.val;
    }

    // Home work iterative approacg TC : O(logn) SC : O(1)
}