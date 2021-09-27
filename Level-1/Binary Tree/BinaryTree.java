import java.util.ArrayList;

public class BinaryTree{
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
            this(data,null,null); // Constructor Chinnin -> calling constructor from another constructor 
        }
    }
    
    // O(n)
    public static void preorder(Node root,ArrayList<Integer> ans){
        if(root == null)   return;

        ans.add(root.data);
        preorder(root.left,ans);
        preorder(root.right,ans);
    }

    // O(n)
    public static void Inorder(Node root,ArrayList<Integer> ans){
        if(root == null )   return;

        Inorder(root.left, ans);
        ans.add(root.data);
        Inorder(root.right, ans);
    }

    // O(n)
    public static void postorder(Node root,ArrayList<Integer> ans){
        if(root == null)    return;

        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.data);
    }

    public static int size(Node root){
        if(root == null)   return 0;
    
        int leftsize = size(root.left);
        int rightsize = size(root.right);
        return leftsize + rightsize + 1;
        // return root == null ? 0 : size(leftsize) + size(rightsize) + 1;
    }

    public static int sum(Node root){
        ///Postorder traversal
        if(root == null)    return 0;

        int leftsum = sum(root.left);
        int rightsum = sum(root.right);
        return leftsum + rightsum + root.data;
        // return root == null ? 0 : sum(root.left) + sum(root.right) + root.data;
    }

    public static int max(Node root){
        if(root == null)    return -(int)1e9;

        int leftmax = max(root.left);
        int rightmax = max(root.right);

        return Math.max(root.data,Math.max(leftmax, rightmax));
        // return root == null ? -(int)1e9 : Math.max(root.data,Math.max(max(root.left),max(root.right)));
    }

    public static int min(Node root){
        if(root == null)    return (int)1e9;

        int leftmin = min(root.left);
        int rightmin = min(root.right);

        return Math.min(leftmin,rightmin);
        // return root == null ? (int)1e9 : Math.min(root.data,Math.min(min(root.left),min(root.right)));
    }

    public static int height(Node root){
        if(root == null)    return -1;

        int leftHeight = height(root.left);
        int rightheight = height(root.right);

        return Math.max(leftHeight,rightheight) + 1;

        // return root == null ? -1 : Math.max(height(root.left),height(root.right)) + 1;
    }

    public static void Exactlyonechild(Node root, ArrayList<Integer> ans){
        if(root == null)    return;
        
        if(root.left == null && root.right == null){
            return;
        }
        else if(root.left == null  || root.right == null){
            ans.add(root.data);
        }

        Exactlyonechild(root.left, ans);
        Exactlyonechild(root.right, ans);
    }

    public static int countleaves(Node root){
        if(root == null)    return 0;

        if(root.left == null && root.right == null) return 1;

        int leftcount = countleaves(root.left);
        int rightcount = countleaves(root.right);

        return leftcount + rightcount;

    }

    public static int countExactlyOneChild(Node root){
        if(root == null || (root.left == null && root.right == null))    return 0;

        int leftcount = countExactlyOneChild(root.left); 
        int rightcount = countExactlyOneChild(root.right);
        int sum = leftcount + rightcount;

        if(root.left == null || root.right == null){
            sum = sum + 1;
        }

        return sum;
    }

    // Find Function
    public static boolean find(Node root,int data){
        if(root == null)    return false;

        if(root.data == data)   return true;

        return find(root.left,data) || find(root.right,data);
    }


    // Node to root path
    // 1st Method
    
    public static boolean nodeToroot(Node root,int data,ArrayList<Node> ans){
        if(root == null)    return false;

        if(root.data == data){
            ans.add(root);
            return true;
        }
        
        boolean res = nodeToroot(root.left, data, ans) || nodeToroot(root.right, data, ans);
        if(res)
            ans.add(root);
        return res;
    }

    
    // Node to root path
    // 2nd Method
    public static ArrayList<Node> nodetorootpath(Node root , int data){
        if(root == null)    return null;

        if(root.data == data){
            ArrayList<Node> list = new ArrayList<>();
            list.add(root);
            return list;
        }

        ArrayList<Node> left = nodetorootpath(root.left,data);
        if(left != null){
            left.add(root);
            return left;
        }

        ArrayList<Node> right = nodetorootpath(root.right,data);
        if(right != null){
            right.add(root);
            return right;
        }
        return null;
    }

    public static ArrayList<Node> nodetorootpath1(Node root , int data){
        ArrayList<Node> ans = nodetorootpath(root, data);
        return ans != null ? ans : new ArrayList<>();
    }

    public static void kLevelsDown(Node root,int k,ArrayList<Integer> ans){
        if(root == null || k < 0)   return;
        
        if(k == 0){
            ans.add(root.data);
            return;
        }

        kLevelsDown(root.left, k - 1, ans);
        kLevelsDown(root.right, k - 1, ans);
    }

    // K-away
    public static void kLevelsdown(Node root,int k,Node block,ArrayList<Integer> ans){
        if(root == null || k < 0 || root == block)   return;
        
        if(k == 0){
            ans.add(root.data);
            return;
        }

        kLevelsdown(root.left, k - 1,block, ans);
        kLevelsdown(root.right, k - 1,block, ans);
    }
    

    public static ArrayList<Integer> kaway(Node node,int data,int k){
        ArrayList<Node> list = new ArrayList<>();
        nodeToroot(node,data,list);

        ArrayList<Integer> ans = new ArrayList<>();
        Node block = null;
        for(int i=0;i<list.size();i++){
            kLevelsdown(list.get(i), k - i, block,ans);
            block = list.get(i);
        }
        return ans;
    } 
}