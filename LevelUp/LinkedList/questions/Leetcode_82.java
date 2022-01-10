package questions;

public class Leetcode_82 {
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode p, curr = head, dummy = new ListNode(-101);
            p = dummy;
            dummy.next = head;
            while (curr != null && curr.next != null) {
                if (curr.val == curr.next.val) {
                    while (curr.next != null && curr.val == curr.next.val) {
                        curr = curr.next;
                    }
                    curr = curr.next;
                    p.next = curr;
                } else {
                    curr = curr.next;
                    p = p.next;
                }
            }
            return dummy.next;
        }
    }
}
