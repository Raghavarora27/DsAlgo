package questions;

public class Leetcode_2095 {
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
        public ListNode deleteMiddle(ListNode head) {
            if (head == null || head.next == null)
                return null;

            int len = length(head);
            int idx = (len / 2) - 1;

            ListNode curr = head;
            while (idx-- > 0) {
                curr = curr.next;
            }

            ListNode forw = curr.next;
            curr.next = forw.next;
            forw.next = null;

            return head;
        }

        public int length(ListNode head) {
            if (head == null)
                return 0;

            int len = 0;
            ListNode curr = head;
            while (curr != null) {
                curr = curr.next;
                len++;
            }

            return len;
        }
    }
}
