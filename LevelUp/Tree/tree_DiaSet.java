import java.util.ArrayList;

public class tree_DiaSet {

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
    return root == null
      ? -1
      : Math.max(height(root.left), height(root.right)) + 1;
  }

  // Diameter of Binary Tree
  // O(n^2)
  public static int diameter_01(TreeNode root) {
    if (root == null) return 0;

    int ld = diameter_01(root.left);
    int rd = diameter_01(root.right);

    int lh = height(root.left);
    int rh = height(root.right);

    return Math.max(Math.max(ld, rd), lh + rh + 2);
  }

  // {d,h}
  public static int[] diameter_02(TreeNode root) {
    if (root == null) return new int[] { 0, -1 };

    int[] lr = diameter_02(root.left);
    int[] rr = diameter_02(root.right);

    int[] myRes = new int[2];
    myRes[0] = Math.max(Math.max(lr[0], rr[0]), lr[1] + rr[1] + 2);
    myRes[1] = Math.max(lr[1], rr[1]) + 1;

    return myRes;
  }

  // Path Sum
  public static boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;

    if (root.left == null && root.right == null) return (
      targetSum - root.val == 0
    );

    return (
      hasPathSum(root.left, targetSum - root.val) ||
      hasPathSum(root.right, targetSum - root.val)
    );
  }

  // Path Sum in Binary Tree 2
  public static void path(
    TreeNode root,
    int target,
    ArrayList<ArrayList<Integer>> ans,
    ArrayList<Integer> smallAns
  ) {
    if (root == null) return;

    if (root.left == null && root.right == null) {
      if (target - root.val == 0) {
        ArrayList<Integer> base = new ArrayList<>(smallAns);
        base.add(root.val);
        ans.add(base);
      }
      return;
    }

    smallAns.add(root.val);
    path(root.left, target - root.val, ans, smallAns);
    path(root.right, target - root.val, ans, smallAns);
    smallAns.remove(smallAns.size() - 1);
  }

  // maximum path sum between 2 leaves
  // {LeafToLeafMaxPath,NodetoLeafMaxPath}
  public static int[] maxPathSum(TreeNode root) {
    if (root == null) return new int[] { -(int) 1e9, -(int) 1e9 };

    if (root.left == null && root.right == null) return new int[] {
      -(int) 1e9,
      root.val,
    }; // leaf

    int[] lr = maxPathSum(root.left);
    int[] rr = maxPathSum(root.right);

    int[] res = new int[2];
    res[0] = Math.max(lr[0], rr[0]);
    if (root.left != null && root.right != null) res[0] =
      Math.max(res[0], lr[1] + rr[1] + root.val);

    res[1] = Math.max(lr[1], rr[1]) + root.val;
    return res;
  }

  static int LeafToLeafMaxPathSum = -(int) 1e9;

  public static int maxPathSum_02(TreeNode root) {
    if (root == null) return -(int) 1e9;

    if (root.left == null && root.right == null) return root.val;

    int lnl = maxPathSum_02(root.left);
    int rnl = maxPathSum_02(root.right);

    if (root.left != null && root.right != null) LeafToLeafMaxPathSum =
      Math.max(LeafToLeafMaxPathSum, lnl + root.val + rnl);

    return Math.max(lnl, rnl) + root.val;
  }

  // Node to Node max path sum
  // 124. Binary Tree Maximum Path Sum
  static int NodetoNodeMaxPathSum = -(int) 1e9;
  public static int maxPathSum_(TreeNode root) {
    if (root == null) return 0;

    int lrtn = maxPathSum_(root.left); // left root to Node
    int rrtn = maxPathSum_(root.right); // right root to Node

    int rootToNode = Math.max(lrtn, rrtn) + root.val;
    NodetoNodeMaxPathSum =
      max(rootToNode, NodetoNodeMaxPathSum, root.val, lrtn + root.val + rrtn);

    return max(root.val, rootToNode);
  }

  public static int max(int... arr) {
    int ans = arr[0];
    for (int ele : arr) ans = Math.max(ans, ele);

    return ans;
  }
}
