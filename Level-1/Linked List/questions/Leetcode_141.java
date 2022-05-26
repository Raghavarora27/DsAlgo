import java.util.HashSet;

public class Leetcode_141 {

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public class Solution {

    public boolean hasCycle(ListNode head) {
      ListNode fast = head;
      ListNode slow = head;

      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) return true;
      }

      return false;
    }
  }

  public class Solution2 {

    public boolean hasCycle(ListNode head) {
      HashSet<ListNode> set = new HashSet<>();

      ListNode curr = head;
      while (curr != null) {
        if (set.contains(curr)) return true; else set.add(curr);
        curr = curr.next;
      }

      return false;
    }
  }
}
