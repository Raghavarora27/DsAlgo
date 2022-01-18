public class pract {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode MergeTwoSortedLL(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null)
            return head1 == null ? head2 : head1;

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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null)
            return head;

        ListNode fast = head,slow = head;
        while(n-- > 0)
            fast = fast.next;

        if(fast == null){
            ListNode rNode = slow;
            head = head.next;
            rNode.next = null;
            return head;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        ListNode rNode = slow.next;
        slow.next = rNode.next;
        rNode.next = null;
        return rNode;
    }

    
}
