import java.util.ArrayList;

public class prac {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val){
            this.val = val;
        }
    }

    public static ArrayList<TreeNode> NodeToRootPath(TreeNode root,TreeNode data){
        if(root == null){
            ArrayList<TreeNode> base = new ArrayList<>();
            return base;
        }
           
        ArrayList<TreeNode> ans = new ArrayList<>();
        if(root == data){
            ans.add(root);
            return ans;
        }

        ArrayList<TreeNode> left =  NodeToRootPath(root.left, data); 
        if(left.size() != 0){
            left.add(root);
            return left;
        }
        ArrayList<TreeNode> right = NodeToRootPath(root.right, data);
        if(right.size() != 0){
            right.add(root);
            return right;
        }
        return ans;
    }

    public static ArrayList<Integer> kaway (TreeNode root,int k,TreeNode target){
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<TreeNode> path  = NodeToRootPath(root, target);

        TreeNode block = null;
        for(int i = 0;i < ans.size();i++){
            kDown(path.get(i),k - i,block,ans);
            block = path.get(i);
        }

        return ans;
    }

    public static void kDown(TreeNode root,int k,TreeNode block,ArrayList<Integer> ans){
        if(root == null || root == block || k < 0)
            return;

        if(k == 0){
            ans.add(root.val);
            return;
        }

        kDown(root.left, k - 1, block, ans);
        kDown(root.right, k - 1, block, ans);
    }
}
