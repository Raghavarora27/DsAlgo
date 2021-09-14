package questions;

public class GFG_EvenOdd {

    class Node{
        int data;
        Node next;
        
        Node(int x){
            data = x;
            next = null;
        }
    }
    
    class Solution {
        Node divide(int N, Node head) {
            if (head == null || head.next == null)
                return head;

            Node Even = new Node(-1); // Dummy Node
            Node ep = Even;

            Node Odd = new Node(-1); // Dummy Node
            Node op = Odd;

            Node curr = head;
            while (curr != null) {
                if (curr.data % 2 == 0) {
                    ep.next = curr;
                    ep = ep.next;
                } else {
                    op.next = curr;
                    op = op.next;
                }
                curr = curr.next;
            }

            ep.next = Odd.next;
            op.next = null;

            return Even.next;
        }
    }
}
