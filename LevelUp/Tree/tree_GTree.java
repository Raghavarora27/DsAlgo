import java.util.ArrayList;
import javax.swing.text.AsyncBoxView.ChildLocator;

public class tree_GTree {

  public class TreeNode {

    int val = 0;
    ArrayList<TreeNode> children;

    TreeNode(int val) {
      this.val = val;
      this.children = new ArrayList<>();
    }
  }

  public static int height(TreeNode root) {
    int maxHeight = -1;
    for (TreeNode child : root.children) {
      maxHeight = Math.max(maxHeight, height(child));
    }

    return maxHeight + 1;
  }

  public static int size(TreeNode root) {
    int s = 0;
    for (TreeNode child : root.children) {
      s += size(child);
    }

    return s + 1;
  }

  public static int maximumEle(TreeNode root) {
    int maxEle = root.val;
    for (TreeNode child : root.children) {
      maxEle = Math.max(maxEle, maximumEle(child));
    }

    return maxEle;
  }

  public static boolean find(TreeNode root, int data) {
    if (root.val == data) return true;

    boolean res = false;
    for (TreeNode child : root.children) {
      res = res || find(child, data);
    }

    return res;
  }

  public static boolean rootToNodePath(
    TreeNode root,
    int data,
    ArrayList<TreeNode> ans
  ) {
    if (root.val == data) {
      ans.add(root);
      return true;
    }

    boolean res = false;
    for (TreeNode child : root.children) {
      res = res || rootToNodePath(child, data, ans);
    }

    if (res) ans.add(root);

    return res;
  }
  // try burning tree ques in Generic Tree

  // public static int diameter(TreeNode root){

  // }
}
