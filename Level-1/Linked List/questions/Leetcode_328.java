package questions;

public class Leetcode_328 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            ListNode Even = new ListNode(-1);
            ListNode ep = Even;

            ListNode Odd = new ListNode(-1);
            ListNode op = Odd;

            ListNode curr = head;
            int idx = 1;
            while (curr != null) {
                if (idx % 2 == 0) {
                    ep.next = curr;
                    ep = ep.next;
                } else {
                    op.next = curr;
                    op = op.next;
                }
                curr = curr.next;
                idx++;
            }

            op.next = Even.next;
            ep.next = null;
            return Odd.next;
        }
    }
}
