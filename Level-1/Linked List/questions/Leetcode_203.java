package questions;

public class Leetcode_203 {
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
        public ListNode removeElements(ListNode head, int val) {
            if (head == null)
                return head;

            ListNode dummy = new ListNode(-1);
            ListNode dp = dummy;
            ListNode curr = head;

            while (curr != null) {
                if (curr.val != val) {
                    dp.next = curr;
                    dp = dp.next;
                }
                curr = curr.next;
            }
            dp.next = null;
            return dummy.next;
        }
    }
}
