import java.util.ArrayList;

public class BoundaryTraversal {
    public static void leftBoundary(TreeNode root,ArrayList<Integer> ans){
        TreeNode curr = root.left;
        while(curr != null){
            if(curr.left != null || curr.right != null){
                ans.add(curr.data);
            }
            if(curr.left != null)    curr = curr.left;
            else    curr = curr.right;
        }
    }
       
    public static void rightBoundary(TreeNode root,ArrayList<Integer> ans){
        TreeNode curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(curr.left != null || curr.right != null){
                temp.add(curr.data);
            }
            if(curr.right != null)    curr = curr.right;
            else    curr = curr.left;
        }
        
        for(int i = temp.size() - 1;i >= 0;i--){
            ans.add(temp.get(i));
        }
    }
    
    public static void leafNodes(TreeNode root,ArrayList<Integer> ans){
        if(root == null)
            return;
        
        if(root.left == null && root.right == null){
            ans.add(root.data);
            return;
        }
        
        leafNodes(root.left,ans);
        leafNodes(root.right,ans);
    }
	
    public static ArrayList<Integer> traverseBoundary(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        if(root.left != null || root.right != null)
            ans.add(root.data);
		leftBoundary(root,ans);
        leafNodes(root,ans);
        rightBoundary(root,ans);
        return ans;
	}
}