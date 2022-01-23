import java.util.HashSet;

public class Leetcode_817 {
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
        public int numComponents(ListNode head, int[] nums) {
            HashSet<Integer> ans = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                ans.add(nums[i]);
            }
            int count = 0;
            ListNode curr = head;
            while (curr != null) {
                if (ans.contains(curr.val)) {
                    while (curr.next != null && ans.contains(curr.next.val)) {
                        curr = curr.next;
                    }
                    count++;
                }
                curr = curr.next;
            }
            return count;
        }
    }
}