import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Questions -- 
    // 1. Size, height, maximum, minimum, find
    // 2. Node to Root Path (with return and void type)
    // 3. Root To Leaf Path
    // 4. Exactly one Child, Count Exactly one Child
    // 5. K-Away (includes Kdown)
    // 6. Burning Tree Node and Burning Tree Node with Water
    // 7. Lowest Common Ancestor of Binary Tree (TC : O(n) SC : O(n))
    // 8. Optimised LCA (TC : O(n) SC : O(1))

public class tree_findSet {
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
        return root == null ? -(int) 1e9 : Math.max(Math.max(maximum(root.left), maximum(root.right)), root.val);
    }

    public static int minimum(TreeNode root) {
        return root == null ? (int) 1e9 : Math.min(Math.min(minimum(root.left), minimum(root.right)), root.val);
    }

    public static boolean find(TreeNode root, int data) {
        if (root == null)
            return false;

        if (root.val == data)
            return true;

        return find(root.left, data) || find(root.right, data);
    }

    public static boolean NodeToRootPath(TreeNode root, int data, ArrayList<TreeNode> ans) {
        if (root == null)
            return false;

        if (root.val == data) {
            ans.add(root);
            return true;
        }

        boolean res = NodeToRootPath(root.left, data, ans) || NodeToRootPath(root.right, data, ans);

        if (res)
            ans.add(root);

        return res;
    }

    public static ArrayList<TreeNode> NodeToRootPath(TreeNode root, int data) {
        if (root == null)
            return new ArrayList<>();

        if (root.val == data) {
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(root);
            return base;
        }

        ArrayList<TreeNode> left = NodeToRootPath(root.left, data);
        if (left.size() != 0) {
            left.add(root);
            return left;
        }

        ArrayList<TreeNode> right = NodeToRootPath(root.right, data);
        if (right.size() != 0) {
            right.add(root);
            return right;
        }

        return new ArrayList<>();
    }

    public static void rootToAllLeafPath(TreeNode root, ArrayList<ArrayList<Integer>> ans,
            ArrayList<Integer> smallAns) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            ArrayList<Integer> base = new ArrayList<>(smallAns);
            base.add(root.val);
            ans.add(base);
            return;
        }

        smallAns.add(root.val);
        rootToAllLeafPath(root.left, ans, smallAns);
        rootToAllLeafPath(root.right, ans, smallAns);
        smallAns.remove(smallAns.size() - 1);
    }

    public static ArrayList<ArrayList<Integer>> rootToLeafPath(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> smallAns = new ArrayList<>();

        rootToAllLeafPath(root, ans, smallAns);
        return ans;
    }

    public static void exactlyoneChild(TreeNode root, ArrayList<Integer> ans) {
        if (root == null || (root.left == null && root.right == null))
            return;

        if (root.left == null || root.right == null) {
            ans.add(root.val);
        }

        exactlyoneChild(root.left, ans);
        exactlyoneChild(root.right, ans);
    }

    public static int CountexactlyoneChild(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return 0;

        int left = CountexactlyoneChild(root.left);
        int right = CountexactlyoneChild(root.right);

        int ans = left + right;
        if (root.left == null || root.right == null)
            ans++;

        return ans;
    }

    public static void kdown(TreeNode root, int k, TreeNode block, ArrayList<Integer> ans) {
        if (root == null || k < 0 || root == block)
            return;

        if (k == 0) {
            ans.add(root.val);
            return;
        }

        kdown(root.left, k - 1, block, ans);
        kdown(root.right, k - 1, block, ans);
    }

    public static ArrayList<Integer> kaway(TreeNode root, int k, TreeNode target) {
        ArrayList<TreeNode> path = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        NodeToRootPath(root, target.val, path);
        TreeNode block = null;
        for (int i = 0; i < path.size(); i++) {
            kdown(path.get(i), k - i, block, ans);
            block = path.get(i);
        }
        return ans;
    }

    // burning Tree =====================================================
    // moving downWards and burning nodes

    public static void burningTreeNode(TreeNode root, int time, TreeNode blockNode, ArrayList<ArrayList<Integer>> ans) {
        if (root == null || root == blockNode)
            return;

        if (time == ans.size())
            ans.add(new ArrayList<>());

        ans.get(time).add(root.val);

        burningTreeNode(root.left, time + 1, blockNode, ans);
        burningTreeNode(root.right, time + 1, blockNode, ans);
    }

    public static int burningTree(TreeNode root, int fireNode, ArrayList<ArrayList<Integer>> ans) {
        if (root == null)
            return -1;

        if (root.val == fireNode) {
            burningTreeNode(root, 0, null, ans);
            return 1;
        }

        int lt = burningTree(root.left, fireNode, ans);
        if (lt != -1) {
            burningTreeNode(root, lt, root.left, ans);
            return lt + 1;
        }

        int rt = burningTree(root.right, fireNode, ans);
        if (rt != -1) {
            burningTreeNode(root, rt, root.right, ans);
            return rt + 1;
        }

        return -1;
    }

    // burning tree with water nodes
    // ========================================================

    public static void burningTreeNodeWithWater(TreeNode root, int time, TreeNode blockNode, HashSet<Integer> Waterset,
            ArrayList<ArrayList<Integer>> ans) {
        if (root == null || root == blockNode || Waterset.contains(root.val))
            return;

        if (time == ans.size())
            ans.add(new ArrayList<>());

        ans.get(time).add(root.val);

        burningTreeNodeWithWater(root.left, time + 1, blockNode, Waterset, ans);
        burningTreeNodeWithWater(root.right, time + 1, blockNode, Waterset, ans);
    }

    public static int burningTreeWithWater(TreeNode root, int fireNode, HashSet<Integer> Waterset,
            ArrayList<ArrayList<Integer>> ans) {
        if (root == null)
            return -1;

        if (root.val == fireNode) {
            if (!Waterset.contains(root.val)) {
                burningTreeNodeWithWater(root, 0, null, Waterset, ans);
                return 1;
            }
            return -2; // fireNode is present but it has Water
        }

        int lt = burningTreeWithWater(root.left, fireNode, Waterset, ans);
        if (lt > 0) {
            if (!Waterset.contains(root.val)) {
                burningTreeNodeWithWater(root, lt, root.left, Waterset, ans);
                return lt + 1;
            }
            return -2; // fireNode is present but it has Water
        }

        if (lt == -2)
            return -2;

        int rt = burningTreeWithWater(root.right, fireNode, Waterset, ans);
        if (rt > 0) {
            if (!Waterset.contains(root.val)) {
                burningTreeNodeWithWater(root, rt, root.right, Waterset, ans);
                return rt + 1;
            }
            return -2; // fireNode is present but it has Water
        }

        if (rt == -2)
            return -2;

        return -1;
    }

    // TC : O(N) SC: O(N)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ans = new ArrayList<>();
        List<TreeNode> ans1 = new ArrayList<>();
        NodeToRootPath_(root, p.val, ans);
        NodeToRootPath_(root, q.val, ans1);

        TreeNode LCA = null;
        int i = ans.size() - 1, j = ans1.size() - 1;
        while (i >= 0 && j >= 0) {
            if (ans.get(i) != ans1.get(j))
                break;
            LCA = ans.get(i);
            i--;
            j--;
        }

        return LCA;
    }

    public static boolean NodeToRootPath_(TreeNode root, int data, List<TreeNode> ans) {
        if (root == null)
            return false;

        if (root.val == data) {
            ans.add(root);
            return true;
        }

        boolean res = NodeToRootPath_(root.left, data, ans) || NodeToRootPath_(root.right, data, ans);

        if (res)
            ans.add(root);

        return res;
    }

    // optimised
    // TC : O(N) SC: O(1)
    static TreeNode LCANode = null;

    public static boolean lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;

        boolean selfPresent = (root == p || root == q);

        boolean leftPresent = lowestCommonAncestor_(root.left, p, q);
        if (LCANode != null)
            return true;
        boolean rightPresent = lowestCommonAncestor_(root.right, p, q);
        if (LCANode != null)
            return true;

        if ((leftPresent && rightPresent) || (selfPresent && rightPresent) || (selfPresent && leftPresent))
            LCANode = root;

        return leftPresent || rightPresent || selfPresent;
    }
}