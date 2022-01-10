package questions;

public class Leetcode_138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // This Question is the Example of Deep Copy
    class Solution {
        public Node copyRandomList(Node head) {
            copyList(head);
            copyRandoms(head);
            return extractList(head);
        }

        public void copyList(Node head) {
            Node curr = head;
            while (curr != null) {
                Node forw = curr.next;
                Node node = new Node(curr.val);

                curr.next = node;
                node.next = forw;

                curr = forw;
            }
        }

        public void copyRandoms(Node head) {
            Node curr = head;
            while (curr != null) {
                if (curr.random != null) {
                    curr.next.random = curr.random.next;
                }

                curr = curr.next.next;
            }
        }

        public Node extractList(Node head) {
            Node curr = head, dummy = new Node(-1), prev = dummy;
            while (curr != null) {
                Node forw = curr.next.next; // backup

                prev.next = curr.next; // links
                curr.next = forw;

                curr = forw; // move
                prev = prev.next;
            }

            return dummy.next;
        }
    }
}
