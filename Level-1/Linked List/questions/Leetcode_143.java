package questions;

public class Leetcode_143 {
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

        public ListNode mid(ListNode head) {
            if (head == null || head.next == null)
                return head;

            ListNode slow = head, fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public ListNode reverse(ListNode head) {
            ListNode curr = head;
            ListNode prev = null;

            while (curr != null) {
                ListNode forw = curr.next;

                curr.next = prev;
                prev = curr;
                curr = forw;
            }
            return prev;
        }

        public void reorderList(ListNode head) {
            ListNode mid = mid(head);
            ListNode nhead = mid.next;
            mid.next = null;

            nhead = reverse(nhead);

            ListNode c1 = head, c2 = nhead;
            while (c2 != null) {
                ListNode f1 = c1.next;
                ListNode f2 = c2.next;

                c1.next = c2;
                c2.next = f1;

                c1 = f1;
                c2 = f2;
            }
        }
    }
}
