package questions;

public class Leetcoode_92 {
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
        public ListNode reverseBetween(ListNode head, int n, int m) {
            if (head == null || head.next == null || n == m)
                return head;

            ListNode dummy = new ListNode(-1), prev = dummy, curr = head;
            int i = 1;
            while (i <= m) {
                while (i >= n && i <= m) {
                    ListNode forw = curr.next;
                    curr.next = null;
                    addFirstNode(curr);
                    curr = forw;
                    i++;
                }

                if (i > m) {
                    prev.next = th;
                    tt.next = curr;
                    break;
                }

                i++;
                prev.next = curr;
                prev = curr;
                curr = curr.next;
            }

            return dummy.next;
        }

        public ListNode th = null, tt = null;

        private void addFirstNode(ListNode node) {
            if (th == null) {
                th = tt = node;
            } else {
                node.next = th;
                th = node;
            }
        }
    }
}
