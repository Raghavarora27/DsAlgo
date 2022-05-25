import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

  // Diameter of Generic Tree
  // {d,h}
  // do this using class
  public static int[] diameter_01(TreeNode root) {
    int h1 = -1, h2 = -1, d = 0;
    for (TreeNode child : root.children) {
      int[] ans = diameter_01(child);
      if (ans[1] > h1) {
        h2 = h1;
        h1 = ans[1];
      } else if (ans[1] > h2) {
        h2 = ans[1];
      }

      d = Math.max(d, ans[0]);
    }

    return new int[] { Math.max(h1 + h2 + 2, d), Math.max(h1, h2) + 1 };
  }

  public static int d = 0;

  public static int diameter_02(TreeNode root) {
    int h1 = -1, h2 = -1;
    for (TreeNode child : root.children) {
      int h = diameter_02(child);
      if (h > h1) {
        h2 = h1;
        h1 = h;
      } else if (h > h2) {
        h2 = h;
      }
    }
    d = Math.max(d, h1 + h2 + 2);

    return Math.max(h1, h2) + 1;
  }

  public static int diameter(TreeNode root) {
    if (root == null) return 0;

    // return diameter_01(root)[0];
    diameter_02(root);
    return d;
  }

  // Serialize and DeSerialize
  public class codec {

    public void Serialize(TreeNode root, StringBuilder sb) {
      sb.append(root.val + " ");
      for (TreeNode child : root.children) {
        Serialize(child, sb);
      }

      sb.append("null ");
    }

    public String Serialize(TreeNode root) {
      if (root == null) return "";
      StringBuilder sb = new StringBuilder();
      Serialize(root, sb);
      return sb.toString();
    }

    public TreeNode DeSerialize(String data) {
      if (data.length() == 0) return null;
      String[] arr = data.split(" ");
      LinkedList<TreeNode> st = new LinkedList<>();
      for (int i = 0; i < arr.length - 1; i++) {
        String s = arr[i];
        if (!s.equals("null")) {
          st.addFirst(new TreeNode(Integer.parseInt(s)));
        } else {
          TreeNode node = st.removeFirst();
          st.getFirst().children.add(node);
        }
      }

      return st.removeFirst();
    }
  }

  // BFS
  public static void level(TreeNode node, List<List<Integer>> res) {
    LinkedList<TreeNode> que = new LinkedList<>();
    que.addLast(node);

    while (que.size() != 0) {
      int size = que.size();
      List<Integer> ans = new ArrayList<>();
      while (size-- > 0) {
        TreeNode rn = que.removeFirst();
        ans.add(rn.val);

        for (TreeNode child : rn.children) que.addLast(child);
      }
      res.add(ans);
    }
  }

  public static void levelOrderZigZag(TreeNode root) {
    if (root == null) return;
    LinkedList<TreeNode> que = new LinkedList<>(); // removeFirst, addLast
    LinkedList<TreeNode> st = new LinkedList<>(); // removeFirst, addFirst
    que.addLast(root);

    int level = 0;
    List<List<Integer>> ans = new ArrayList<>();
    while (que.size() != 0) {
      int size = que.size(); // size of current level
      List<Integer> res = new ArrayList<>();
      while (size-- > 0) {
        TreeNode rn = que.removeFirst();
        res.add(rn.val);

        if (level % 2 == 0) {
          for (TreeNode child : rn.children) {
            st.addFirst(child);
          }
        } else {
          for (int i = rn.children.size() - 1; i >= 0; i--) {
            TreeNode child = rn.children.get(i);
            st.addFirst(child);
          }
        }
      }
      ans.add(res);
      level++;
      LinkedList<TreeNode> temp = que;
      que = st;
      st = temp;
    }
    for (List<Integer> a : ans) {
      for (int ele : a) System.out.print(ele + " ");
      System.out.println();
    }
  }

  // Linearise
  public static TreeNode linearise(TreeNode root) {
    if (root.children.size() == 0) return root;

    TreeNode gTail = linearise(root.children.get(root.children.size() - 1));
    for (int i = root.children.size() - 2; i >= 0; i--) {
      TreeNode child = root.children.get(i);
      TreeNode tail = linearise(child);
      tail.children.add(root.children.get(i + 1));
      root.children.remove(root.children.size() - 1);
    }

    return gTail;
  }

  // Is Mirror
  public static boolean isMirror(TreeNode root1, TreeNode root2) {
    if (root1.children.size() != root2.children.size()) return false;

    int size = root1.children.size();
    for (int i = 0, j = size - 1; j >= 0; i++, j--) {
      TreeNode child1 = root1.children.get(i);
      TreeNode child2 = root2.children.get(j);

      if (!isMirror(child1, child2)) return false;
    }

    return true;
  }

  // Better Approach using Priority Queue O(KLogn)
  // Do using recursion, O(kN)
  // public static int kThLargest(TreeNode node, int k) {

  // }
}
