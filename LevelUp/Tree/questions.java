public class questions {

  public class TreeNode {

    TreeNode left = null;
    TreeNode right = null;
    int val = 0;

    TreeNode(int val) {
      this.val = val;
    }
  }

  // 968
  // -1 : need a camera, 0 : it has a camera, 1 : it doesn't require any camera
  public static int camera = 0;

  public static int minCameraCover_(TreeNode root) {
    if (root == null) return 1;

    int lc = minCameraCover_(root.left);
    int rc = minCameraCover_(root.right);

    if (lc == -1 || rc == -1) {
      camera++;
      return 0;
    }

    if (lc == 0 || rc == 0) {
      return 1;
    }

    return -1;
  }

  public static int minCameraCover(TreeNode root) {
    if (root == null) return 0;
    if (minCameraCover_(root) == -1) camera++;
    return camera;
  }

  // {rob,without rob}
  public static int[] rob_(TreeNode root) {
    if (root == null) return new int[] { 0, 0 };

    int[] lr = rob_(root.left);
    int[] rr = rob_(root.right);

    int[] ans = new int[2];
    ans[0] = lr[1] + root.val + rr[1];
    ans[1] = Math.max(lr[0], lr[1]) + Math.max(rr[0], rr[1]);

    return ans;
  }

  public static int rob(TreeNode root) {
    if (root == null) return 0;

    int[] ans = rob_(root);
    return Math.max(ans[0], ans[1]);
  }

  // {forwardSlop,backwardSlop,LongestZigZagPath}
  public static int[] longestzigzag(TreeNode root) {
    if (root == null) return new int[] { -1, -1, -1 };

    int[] lr = longestzigzag(root.left);
    int[] rr = longestzigzag(root.right);

    int[] ans = new int[3];
    ans[0] = lr[1] + 1;
    ans[1] = rr[0] + 1;
    ans[2] = Math.max(Math.max(ans[0], ans[1]), Math.max(lr[2], rr[2]));

    return ans;
  }
}
