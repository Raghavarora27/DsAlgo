package Hard;
import java.util.*;

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

    // TC : O(n), SC : O(n)
    // Approach - Add all the Elements in the min priority Queue and remove nodes from pq and connects with the dummy node
    class Solution {
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
