import java.util.*;

public class BST {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(int data) {
            this(data, null, null); // Constructor Chinning
        }
    }

    // T : O(n), S : O(1)
    public static int size(Node node) {
        return node == null ? 0 : size(node.left) + size(node.right) + 1;
    }

    // T : O(logn), S : O(1)
    public static int height(Node node) {
        return node == null ? -1 : Math.max(height(node.left), height(node.right)) + 1;
    }

    // T : O(logn), S : O(1)
    public static int maximum(Node node) {
        while (node.right != null)
            node = node.right;
        return node.data;
    }

    // T : O(logn), S : O(1)
    public static int minimum(Node node) {
        while (node.left != null)
            node = node.left;
        return node.data;
    }

    // T : O(logn), S : O(1)
    public static boolean find(Node node, int data) {
        while (node != null) {
            if (node.data == data)
                return true;
            else if (node.data < data)
                node = node.right;
            else
                node = node.left;
        }
        return false;
    }

    public static int sum(Node node) {
        return node == null ? 0 : sum(node.left) + sum(node.right) + node.data;
    }

    // Do this without recursion
    // T : O(logn), S : O(1)
    // If you know kis side jaana hai then do iterative else recursive
    public static ArrayList<Node> NodetoRootPath(Node node, int data) {
        ArrayList<Node> list = new ArrayList<>();
        boolean flag = false;
        while (node != null) {
            list.add(node);
            if (node.data == data)
                break;
            else if (node.data < data)
                node = node.right;
            else
                node = node.left;
        }

        if (!flag)
            list.clear();

        Collections.reverse(list);
        return list;
    }

    public static int lca(Node node, int d1, int d2) {
        int lca = -1;
        while (node != null) {
            if (node.data > d1 && node.data > d2)
                node = node.left;
            else if (node.data < d1 && node.data < d2)
                node = node.right;
            else {
                lca = node.data;
                break;
            }
        }
        return lca;
    }

    // Print in Range-- O(N)
    public static void pir(Node node, int d1, int d2) {
        if (node == null)
            return;

        pir(node.left, d1, d2);

        if (node.data >= d1 && node.data <= d2)
            System.out.println(node.data);

        pir(node.right, d1, d2);

    }

    public static Node addData(Node node,int data){
        if(node == null)    return new Node(data);

        if(node.data < data)
            node.right = addData(node.right, data);
        else if(node.data > data)
            node.left = addData(node.left, data);
        return node;
    }
    
    public static Node removeData(Node node,int data){
        if(node == null)    return null;

        if(node.data < data)
            node.right = removeData(node.right, data);
        else if(node.data > data)
            node.left = removeData(node.left, data);
        else{
            if(node.left == null || node.right == null)
                return node.left != null ? node.left : node.right;
            int minEle = minimum(node.right);
            node.data = minEle;

            node.right = removeData(node.right, minEle);
        }
            
        return node;
    }

    public static int sum(Node node,int data){
        if(node == null)    return 0;

        int ans = 0;
        int left = sum(node.left);
        
        if(node.data > data){
            ans = left + node.data;
        }            
        
        int right = sum(node.right);
        
        if(node.data > data){
            ans = right + node.data;
        }            

        return ans;
    }

    // Add all greater values to every node in a BST 
    public void modify_(Node root,int [] arr){
        if(root == null)    return;
        
        modify_(root.right,arr);
        root.data += arr[0];
        arr[0] = root.data;
        modify_(root.left,arr);
    }
    
    public Node modify(Node root){
        int [] arr = new int[1];
        modify_(root,arr);
        return root;
    }
    
}
