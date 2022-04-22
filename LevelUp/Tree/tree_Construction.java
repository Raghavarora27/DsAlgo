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

}