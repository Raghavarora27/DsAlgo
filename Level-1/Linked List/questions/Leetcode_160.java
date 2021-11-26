package questions;

public class Leetcode_160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode startA = headA;
            int A = 0;

            while (startA != null) {
                startA = startA.next;
                A++;
            }
            ListNode startB = headB;
            int B = 0;
            while (startB != null) {
                startB = startB.next;
                B++;
            }
            int dif;
            ListNode d1 = headA;
            ListNode d2 = headB;
            if (A > B) {
                dif = A - B;
                while (dif > 0) {
                    d1 = d1.next;
                    dif--;
                }
            } else {
                dif = B - A;
                while (dif > 0) {
                    d2 = d2.next;
                    dif--;
                }
            }
            while (d1 != null || d2 != null) {
                if (d1 == d2) {
                    break;
                }
                d1 = d1.next;
                d2 = d2.next;
            }
            return d1;
        }
    }

    public class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int l1 = length(headA);
            int l2 = length(headB);
            int count = Math.abs(l1 - l2);

            ListNode c1 = headA;
            ListNode c2 = headB;
            if (l1 > l2) {
                while (count-- > 0) {
                    c1 = c1.next;
                }
            } else {
                while (count-- > 0) {
                    c2 = c2.next;
                }
            }

            while (c2 != null) {
                if (c1 == c2)
                    return c2;
                c1 = c1.next;
                c2 = c2.next;
            }
            return null;
        }

        public int length(ListNode head) {
            ListNode curr = head;
            int count = 0;
            while (curr != null) {
                count++;
                curr = curr.next;
            }
            return count;
        }
    }
}
