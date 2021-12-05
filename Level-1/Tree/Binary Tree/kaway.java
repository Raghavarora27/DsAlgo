import java.lang.reflect.Array;
import java.util.ArrayList;

public class kaway {
    public class Node{
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

    public static boolean nodeToRootPath(Node node,int data,ArrayList<Node> ans){
        if(node == null)
            return false;
        
        if(node.data == data){
            ans.add(node);
            return true;
        }

        boolean res = nodeToRootPath(node.left, data, ans) || nodeToRootPath(node.right, data, ans);
        if(res)
            ans.add(node);
        
        return res;
    }

    public static void KLevelsDown(Node node,int k,Node block){
        if(node == null || k < 0 || node == block)
            return;
        
        if(k == 0){
            System.out.println(node.data);
            return;
        }

        KLevelsDown(node.left, k-1, block);
        KLevelsDown(node.right, k-1, block);
    }

    public static void kaway(Node node,int data,int k){
        ArrayList<Node> ans = new ArrayList<>();
        nodeToRootPath(node, data, ans);

        Node block = null;
        for(int i = 0;i < ans.size();i++){
            KLevelsDown(ans.get(i), k - i, block);
            block = ans.get(i);
        }
    }
}
