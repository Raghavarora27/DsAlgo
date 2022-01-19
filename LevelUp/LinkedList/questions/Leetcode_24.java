package questions;

public class Leetcode_24 {

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
        public ListNode th = null, tt = null;

        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null)
                return head;

            int len = length(head);
            ListNode curr = head, oh = null, ot = null;
            while (len >= 2) {
                int tempk = 2;
                while (tempk-- > 0) {
                    ListNode forw = curr.next;
                    curr.next = null;
                    addFirstNode(curr);
                    curr = forw;
                }

                if (oh == null) {
                    oh = th;
                    ot = tt;
                } else {
                    ot.next = th;
                    ot = tt;
                }

                th = tt = null;
                len -= 2;
            }
            ot.next = curr;
            return oh;
        }

        private void addFirstNode(ListNode node) {
            if (th == null) {
                th = tt = node;
            } else {
                node.next = th;
                th = node;
            }
        }

        public int length(ListNode head) {
            if (head == null)
                return 0;
            int len = 0;
            ListNode temp = head;
            while (temp != null) {
                len++;
                temp = temp.next;
            }

            return len;
        }
    }
}
