import java.util.*;

public class Binary{
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(int data){
            this(data,null,null);
        }
    }


    public static void preorder(Node root, ArrayList<Integer> ans){
        if(root == null)    return;

        ans.add(root.data);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
    public static void Inorder(Node root, ArrayList<Integer> ans){
        if(root == null)    return;

        preorder(root.left, ans);
        ans.add(root.data);
        preorder(root.right, ans);
    }
    public static void postorder(Node root, ArrayList<Integer> ans){
        if(root == null)    return;

        preorder(root.left, ans);
        preorder(root.right, ans);
        ans.add(root.data);
    }
}