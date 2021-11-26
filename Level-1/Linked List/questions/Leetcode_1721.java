package questions;

public class Leetcode_1721 {
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
        // TC : O(n) SC : O(1)
        public ListNode swapNodes(ListNode head, int k) {
            ListNode start = head;
            ListNode end = head;
            ListNode slow = head;
            ListNode fast = head;

            while (k-- > 1) {
                fast = fast.next;
            }

            start = fast;

            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            end = slow;

            int temp = start.val;
            start.val = end.val;
            end.val = temp;

            return head;
        }
    }
}
