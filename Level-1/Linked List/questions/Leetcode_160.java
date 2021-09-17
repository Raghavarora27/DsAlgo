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
}
