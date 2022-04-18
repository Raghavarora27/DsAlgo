public class tree_Construction {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode ConstructionFromInOrder(int [] inorder,int si,int ei){
        if(si > ei)
            return null;

        int mid = (si + ei) / 2;
        TreeNode root = new TreeNode(inorder[mid]);

        root.left = ConstructionFromInOrder(inorder, si, mid - 1);
        root.right = ConstructionFromInOrder(inorder, mid + 1, ei);

        return root;
    }

    public static TreeNode ConstructionFromInorder(int [] inorder){
        return ConstructionFromInOrder(inorder, 0, inorder.length - 1);
    }
}