package questions;

public class Leetcode_83 {

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
            if (head == null || head.next == null)
                return head;

            ListNode dummy = new ListNode(-1), dp = dummy, curr = head;

            while (curr != null) {
                while (curr != null && dp.val == curr.val) {
                    ListNode forw = curr.next;
                    curr.next = null;
                    curr = forw;
                }

                dp.next = curr;

                if (curr != null) {
                    dp = dp.next;
                    curr = curr.next;
                }
            }

            return dummy.next;
        }
    }
}
