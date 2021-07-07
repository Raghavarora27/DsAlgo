public class LL_Intro {
    public class Node {
        int data = 0;
        Node next = null;

        // Constructor
        Node(int data) {
            this.data = data;
        }
    }

    // members of LL_Intro class
    // node ka address kiski node ke type me hi toh store hoga
    public Node head = null;
    public Node tail = null;
    public int size = 10;

    // private class Node{
    // int data = 0;
    // Node next = null;

    // //Constructor
    // Node(int data){
    // this.data = data;
    // }
    // }
    // private Node head = null;
    // private Node tail = null;
    // private Node size = null;
    // // you can make this private as well when you dont want to show this to
    // outsiders
    // vohi use kar payenga jisko allow karenge

    public int size(){
        return this.size;
    }

    // Adding node in the starting of the LL
    public void addfirstnode(Node node){
        if(this.size == 0){
            this.head = this.tail = node;
        }
        else{
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    public void addfirst(int data){
        Node node = new Node(data);
        addfirstnode(node);
    }
    // Adding node in the end of the LL

    public void addlastnode(Node node){
        if(this.size == 0){
            this.head = this.tail = node;
        }else{
            this.tail.next = node;
            this.tail = node;
        }
    }   
    public void addlast(int data){
        Node node = new Node(data);
        addlastnode(node);
    }

    //
    public static void main(String[] args) {
        LL_Intro ll = new LL_Intro();
        // ll.size = 10;
        System.out.print(ll.size);
    }
}