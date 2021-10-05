import java.util.ArrayList;

public class GenericTree {
    public class Node{
        int data = 0;
        ArrayList<Node> childs;

        Node(int data){
            this.data = data;
            this.childs = new ArrayList<>();
        }
    }
    
    public static int size(Node node){
        int count = 0;
        
        for(Node child : node.childs)
            count += size(child);
        
        return count + 1;
      }
}
