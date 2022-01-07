package questions;

import java.util.PriorityQueue;

public class Leetcode_23 {

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

    class Solution1 {

        // 2ms // O(nlogk + k)
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0)
                return null;

            return mergeKLists(lists, 0, lists.length - 1);
        }

        public ListNode MergeTwoSortedLL(ListNode head1, ListNode head2) {
            if (head1 == null || head2 == null)
                return head1 != null ? head1 : head2;

            ListNode dummy = new ListNode(-1), dp = dummy, c1 = head1, c2 = head2;

            while (c1 != null && c2 != null) {
                if (c1.val <= c2.val) {
                    dp.next = c1;
                    c1 = c1.next;
                } else {
                    dp.next = c2;
                    c2 = c2.next;
                }

                dp = dp.next;
            }

            dp.next = c1 != null ? c1 : c2;

            return dummy.next;
        }

        public ListNode mergeKLists(ListNode[] lists, int si, int ei) {
            if (si == ei)
                return lists[si];

            int mid = (si + ei) / 2;
            ListNode Leftlist = mergeKLists(lists, si, mid);
            ListNode Rightlist = mergeKLists(lists, mid + 1, ei);

            return MergeTwoSortedLL(Leftlist, Rightlist);
        }
    }

    class Solution2 {
        // 9ms // O(nlogk + n)
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
            ListNode dummy = new ListNode(-1);
            ListNode dp = dummy;

            for (ListNode ele : lists) {
                while (ele != null) {
                    pq.add(ele);
                    ele = ele.next;
                }
            }

            while (pq.size() != 0) {
                dp.next = pq.remove();
                dp = dp.next;
                dp.next = null;
            }
            return dummy.next;
        }
    }
}