package questions;

public class Leetcode_2130 {
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
        public int pairSum(ListNode head) {

            int maxPairSum = 0;
            ListNode mid = mid(head);
            ListNode nhead = mid.next;
            mid.next = null;
            nhead = reverse(nhead);

            ListNode c1 = head, c2 = nhead;
            while (c1 != null) {
                maxPairSum = Math.max(maxPairSum, c1.val + c2.val);
                c1 = c1.next;
                c2 = c2.next;
            }

            return maxPairSum;
        }

        public ListNode reverse(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;

            while (curr != null) {
                ListNode forw = curr.next;

                curr.next = prev;
                prev = curr;
                curr = forw;
            }

            return prev;
        }

        public ListNode mid(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }
}
