import java.util.ArrayList;
import java.util.LinkedList;

public class tree_ViewSet {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void LevelOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        int Level = 0;
        while (que.size() != 0) {
            int size = que.size();
            System.out.print(Level + " -> ");
            while (size-- > 0) {
                TreeNode rn = que.removeFirst();
                System.out.print(rn.val + " ");
                if (rn.left != null)
                    que.addLast(rn.left);

                if (rn.right != null)
                    que.addLast(rn.right);
            }
            System.out.println();
            Level++;
        }
    }

    public static void leftView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        while (que.size() != 0) {
            int size = que.size();
            ans.add(que.getFirst().val);

            while (size-- > 0) {
                TreeNode rn = que.removeFirst();

                if (rn.left != null)
                    que.addLast(rn.left);

                if (rn.right != null)
                    que.addLast(rn.right);
            }
        }

        System.out.println(ans);
    }
    
    public static void RightView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        while (que.size() != 0) {
            int size = que.size();
            ans.add(que.getFirst().val);

            while (size-- > 0) {
                TreeNode rn = que.removeFirst();

                if (rn.right != null)
                    que.addLast(rn.right);
                
                if (rn.left != null)
                    que.addLast(rn.left);
            }
        }

        System.out.println(ans);
    }
}
