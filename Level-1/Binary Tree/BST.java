import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.xml.crypto.Data;

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
    public static int size(Node node){
        return node == null ? 0 : size(node.left) + size(node.right) + 1;
    }
    
    // T : O(logn), S : O(1)  
    public static int height(Node node){
        return node == null ? -1 : Math.max(height(node.left), height(node.right)) + 1; 
    }

    // T : O(logn), S : O(1)    
    public static int maximum(Node node){
        while(node.right != null)
            node = node.right;
        return node.data;
    }

    // T : O(logn), S : O(1)
    public static int minimum(Node node){
        while(node.left != null)
            node = node.left;
        return node.data;
    }

    // T : O(logn), S : O(1)
    public static boolean find(Node node,int data){
        while(node != null){
            if(node.data == data)
                return true;
            else if(node.data < data)
                node = node.right;
            else
                node = node.left;
        }
        return false;
    }

    // Do this without recursion 
    public static ArrayList<Node> NodetoRootPath(Node node,int data){
        ArrayList<Node> list = new ArrayList<>();
        boolean flag = false;
        while(node != null){
            list.add(node);
            if(node.data == data)
                break;
            else if(node.data < data)
                node = node.right;
            else
                node = node.left;
        }
        
        if(!flag)
            list.clear();
        
        Collections.reverse(list);
        return list;
    }
}
