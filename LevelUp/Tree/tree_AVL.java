public class tree_AVL {
  public static class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    int bal = 0;
    int height = 0;

    TreeNode(int val) {
      this.val = val;
    }
  }

  // O(1)
  public static TreeNode rightRotation(TreeNode A) {
    TreeNode B = A.left;

    TreeNode BkaRight = B.right;
    B.right = A;
    A.left = BkaRight;

    updateBalAndHeight(A);
    updateBalAndHeight(B);

    return B;
  }

  // O(1)
  public static TreeNode leftRotation(TreeNode A) {
    TreeNode B = A.right;

    TreeNode BkaLeft = B.left;
    B.left = A;
    A.right = BkaLeft;

    updateBalAndHeight(A);
    updateBalAndHeight(B);

    return B;
  }

  // O(1)
  public static void updateBalAndHeight(TreeNode root) {
    int lh = root.left != null ? root.left.height : -1;
    int rh = root.right != null ? root.right.height : -1;

    int bal = lh - rh;

    root.height = Math.max(lh, rh) + 1;
    root.bal = bal;
  }

  // yeh btayega rotation karne ki need h ya nhi, need hai toh rotate karde nhi toh aase hi return hoja
  // O(1)
  public static TreeNode getRotation(TreeNode root) {
    updateBalAndHeight(root);

    if (root.bal == 2) { // ll, lr
      if (root.left.bal == 1) { // ll
        return rightRotation(root);
      } else { // lr
        root.left = leftRotation(root.left);
        return rightRotation(root);
      }
    } else if (root.bal == -2) { // rr, rl
      if (root.right.bal == -1) { // rr
        return leftRotation(root);
      } else { // rl
        root.right = rightRotation(root.right);
        return leftRotation(root);
      }
    }

    return root;
  }

  // log(n)
  public static TreeNode addData(TreeNode root, int data) {
      if (root == null) return new TreeNode(data);
      
    if (root.val < data) {
      root.right = addData(root.right, data);
    } else {
      root.left = addData(root.left, data);
    }
    return getRotation(root);
  }

  public static int maximum(TreeNode root) {
    TreeNode node = root;
    while (node.right != null) node = node.right;

    return node.val;
  }
  
  // log(n)
  public static TreeNode removeData(TreeNode root, int data) {
    if (root == null) return new TreeNode(data);

    if (root.val < data) {
      root.right = removeData(root.right, data);
    } else if (root.val > data) {
      root.left = removeData(root.left, data);
    } else {
      if (root.left == null || root.right == null) return root.left != null
        ? root.left
        : root.right;

      root.val = maximum(root.left);
      root.left = removeData(root.left, data);
    }

    return getRotation(root);
  }

  public static void Display(TreeNode node) {
    if (node == null) return;

    String str = "";
    str += ((node.left != null ? Integer.toString(node.left.val) : "."));
    str += ("->" + Integer.toString(node.val) + "<-");
    str += ((node.right != null ? Integer.toString(node.right.val) : "."));

    System.out.println(str);
    Display(node.left);
    Display(node.right);
  }

  public static void main(String[] args) {
    TreeNode root = null;
    for (int i = 1; i <= 15; i++) root = addData(root, i * 10);

    Display(root);
  }
}