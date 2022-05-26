import java.util.*;

public class Leetcode_142 {

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public class Solution {

    public ListNode detectCycle(ListNode head) {
      HashSet<ListNode> set = new HashSet<>();

      ListNode curr = head;
      while (curr != null) {
        if (set.contains(curr)) return curr; else set.add(curr);
        curr = curr.next;
      }
      return null;
    }
  }

  public class Solution2 {

    public ListNode detectCycle(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;

      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
          while (slow != head) {
            head = head.next;
            slow = slow.next;
          }
          return slow;
        }
      }

      return null;
    }
  }
}
