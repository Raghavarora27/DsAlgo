import java.util.*;

public class Leetcode_1019 {
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

    // TC : O(n^2) SC : O(1)
    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            int[] ans = new int[length(head)];

            ListNode curr = head;
            int i = 0;
            while (curr.next != null) {
                int ele = nextLarger(curr);
                ans[i++] = ele;
                curr = curr.next;
            }

            return ans;
        }

        public int nextLarger(ListNode head) {
            ListNode curr = head;
            while (curr != null) {
                if (head.val < curr.val)
                    return curr.val;
                curr = curr.next;
            }

            return 0;
        }

        public int length(ListNode head) {
            if (head == null)
                return 0;

            ListNode curr = head;
            int len = 0;
            while (curr != null) {
                len++;
                curr = curr.next;
            }

            return len;
        }
    }

    // TC : O(n) SC : O(2n)
    class Solution2 {
        public int[] nextLargerNodes(ListNode head) {

            List<Integer> arr = new ArrayList<>();

            ListNode curr = head;
            while (curr != null) {
                arr.add(curr.val);
                curr = curr.next;
            }
            int n = arr.size();
            int[] ans = new int[n];

            Stack<Integer> st = new Stack<>();

            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && arr.get(st.peek()) <= arr.get(i))
                    st.pop();

                ans[i] = st.isEmpty() ? 0 : arr.get(st.peek());
                st.push(i);
            }
            return ans;
        }
    }
}