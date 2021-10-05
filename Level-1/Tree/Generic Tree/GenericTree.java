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
            res = res || find(child);
        return res;
    }
}
