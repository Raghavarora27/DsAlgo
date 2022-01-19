package questions;

public class Leetcode_1669 {
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
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            ListNode dummy = new ListNode(-1), dp = dummy, curr = list1;
            int idx = 0;
            while (idx < b && curr != null) {
                if (idx < a) {
                    dp.next = curr;
                    dp = dp.next;
                }
                curr = curr.next;
                idx++;
            }

            ListNode forw = curr.next;
            curr.next = null;
            curr = forw;

            ListNode c2 = list2;
            while (c2 != null) {
                dp.next = c2;
                dp = dp.next;
                c2 = c2.next;
            }

            dp.next = curr;
            return dummy.next;
        }
    }
}
