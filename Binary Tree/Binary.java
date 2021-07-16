import java.util.*;

public class Binary{

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(int data){
            this(data,null,null);
        }
    }

    public static void preorder(Node root,ArrayList<Integer> ans){
        if(root == null)    return;

        ans.add(root.data);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }

    public static void inorder(Node root,ArrayList<Integer> ans){
        if(root == null)    return;

        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }

    public static void postorder(Node root,ArrayList<Integer> ans){
        if(root == null)    return;

        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.data);
    }

    public static int size(Node root){
        if(root == null)    return 0;

        int leftsize = size(root.left);
        int rightsize = size(root.right);

        return leftsize + rightsize + 1;

        // return root == null ? 0 : Math.max(size(root.left),size(root.right)) + 1;
    }

    public static int maxx(Node root){
        return root == null ? -(int)1e9 : Math.max(Math.max(maxx(root.left),maxx(root.right)),root.data);
    }

    public static int minimum(Node root){
        return root == null ? (int)1e9 : Math.min(Math.min(minimum(root.left),minimum(root.right)),root.data);
    }
    public static int height(Node root){
        return root == null ? -1 : Math.max(height(root.left),height(root.right)) + 1;
}