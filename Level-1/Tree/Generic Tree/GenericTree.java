import java.util.ArrayList;

public class GenericTree {
    public class Node {
        int data = 0;
        ArrayList<Node> childs;

        Node(int data) {
            this.data = data;
            this.childs = new ArrayList<>();
        }
    }

    public static int size(Node node) {
        int count = 0;

        for (Node child : node.childs)
            count += size(child);

        return count + 1;
    }

    public static int height(Node root) {
        int h = 0;
        for (Node child : root.children)
            h = Math.max(height(child) + 1, h);

        return h;
    }

    public static int maximum(Node node){
        int max = node.data;
        for(Node child : node.childs)
            max = Math.max(maximum(child),max);
        return max;
    }

    public static int minimum(Node node){
        int min = node.data;
        for(Node child : node.childs)
            min = Math.min(maximum(child),min);
        return min;
    }

    public static int sum(Node node){
        int sum = node.data;
        for(Node child : node.childs)
            sum += sum(child);
        return sum;
    }

    public static boolean find(Node node,int data){
        if(node.data == data)
            return true;

        boolean res = false;
        for(Node child : node.childs)
            res = res || find(child,data);
        return res;
    }
    
    public static boolean find2(Node node,int data){
        if(node.data == data)
            return true;

        boolean res = false;
        for(Node child : node.childs){
            if(find(child,data)){
                res = true;
                break;
            }
        }
        return res;
    }

    public static int countLeaves(Node node){
        if(node.childs.size() == 0) return 1;

        int count = 0;
        for(Node child : node.childs)
            count += countLeaves(child);
        return count;
    }

    public static boolean nodeToRootPath_(Node node,int data,ArrayList<Node> ans){
        if(node.data == data){
            ans.add(node);
            return true;
        }

        boolean res = false;
        for(Node child : node.childs)
            res = res || nodeToRootPath_(child, data, ans);
        
        if(res)
            ans.add(node);
        
        return res;
    }

    public static ArrayList<Node> nodeToRootPath(Node node,int data){
        if(node == null)    return new ArrayList<>();
        ArrayList<Node> ans = new ArrayList<>();
        nodeToRootPath_(node, data, ans);
        return ans;
    }

    public static ArrayList<Node> nodeToRootPath2(Node node,int data){
        if(node.data == data){
            ArrayList<Node> ans = new ArrayList<>();
            ans.add(node);
            return ans;
        }    

        ArrayList<Node> smallAns = new ArrayList<>();
        for(Node child : node.childs){
            smallAns = nodeToRootPath2(child, data);
            if(smallAns.size() != 0)
                break;
        }

        if(smallAns.size() != 0)
            smallAns.add(node);

        return smallAns; 
    }

    public Node lowestCommonAncestor(Node root, int p, int q) {
        ArrayList<Node> list1 = nodeToRootPath(root, p);
        ArrayList<Node> list2 = nodeToRootPath(root, q);

        int i = list1.size() - 1;
        int j = list2.size() - 1;

        Node LCA = null;
        while (i >= 0 && j >= 0) {
            if (list1.get(i) != list2.get(j))
                break;
            LCA = list2.get(j);
            i--;
            j--;

        }

        return LCA;
    }

}
