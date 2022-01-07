public class LinkedList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mid(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode forw = curr.next;

            curr.next = prev;
            prev = curr;
            curr = forw;
        }

        return prev;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode midNode = mid(head);
        ListNode nhead = midNode.next;
        midNode.next = null;

        nhead = reverse(nhead);

        boolean flag = true;
        ListNode curr1 = head, curr2 = nhead;
        while (curr2 != null) {
            if (curr1.val != curr2.val) {
                flag = false;
                break;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        nhead = reverse(head);
        midNode.next = nhead;

        return flag;
    }

    public static void fold(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode midNode = mid(head);
        ListNode nhead = midNode.next;
        midNode.next = null;

        nhead = reverse(nhead);

        ListNode c1 = head, c2 = nhead;
        while (c2 != null) {
            ListNode f1 = c1.next;
            ListNode f2 = c2.next;

            c1.next = c2;
            c2.next = f1;

            c1 = f1;
            c2 = f2;
        }
    }

    public static void unfold(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode d1 = new ListNode(-1);
        ListNode c1 = d1;
        ListNode d2 = new ListNode(-1);
        ListNode c2 = d2;

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            c1.next = curr;
            c2.next = curr.next;

            c1 = c1.next;
            c2 = c2.next;

            curr = curr.next;
            if (curr != null)
                curr = curr.next;
        }

        c1.next = null;
        ListNode rhead = reverse(d2.next);
        c1.next = rhead;
    }

    public static ListNode MergeTwoSortedLL(ListNode head1, ListNode head2) {
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;

        ListNode slow = head, fast = head;

        while (n-- > 0)
            fast = fast.next;

        if (fast == null) {
            ListNode rNode = slow;
            head = head.next;
            rNode.next = null;
            return head;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode rNode = slow.next;
        slow.next = rNode.next;
        rNode.next = null;
        return head;
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode even = new ListNode(-1), ep = even;
        ListNode odd = new ListNode(-1), op = odd;
        ListNode curr = head;

        while (curr != null) {
            if ((curr.val & 1) == 0) { // odd
                op.next = curr;
                op = op.next;
            } else {
                ep.next = curr;
                ep = ep.next;
            }
            curr = curr.next;
        }

        ep.next = op.next = null;
        op.next = even.next;

        return odd.next;
    }

    public static ListNode segregate01(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode zero = new ListNode(-1), zp = zero;
        ListNode one = new ListNode(-1), op = one;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == 0) {
                zp.next = curr;
                zp = zp.next;

            } else {
                op.next = curr;
                op = op.next;
            }
            curr = curr.next;
        }

        zp.next = op.next = null;
        zp.next = one.next;

        return zero.next;
    }

    public static ListNode segregate012(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode zero = new ListNode(-1), zp = zero;
        ListNode one = new ListNode(-1), op = one;
        ListNode two = new ListNode(-1), tp = two;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == 0) {
                zp.next = curr;
                zp = zp.next;

            } else if (curr.val == 1) {
                op.next = curr;
                op = op.next;
            } else {
                tp.next = curr;
                tp = tp.next;
            }
            curr = curr.next;
        }

        zp.next = op.next = tp.next = null;
        op.next = two.next;
        zp.next = one.next;

        return zero.next;
    }

    // O(nlogn)
    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode midNode = mid(head);
        ListNode nHead = midNode.next;
        midNode.next = null;

        return MergeTwoSortedLL(mergeSort(head), mergeSort(nHead));
    }

    // Divide and Conquer Technique (faster than priority queue method)
    // O(nlogk + k)
    public static ListNode mergeKLists(ListNode[] lists, int si, int ei) {
        if (si == ei)
            return lists[si];

        int mid = (si + ei) / 2;
        ListNode Leftlist = mergeKLists(lists, si, mid);
        ListNode Rightlist = mergeKLists(lists, mid + 1, ei);

        return MergeTwoSortedLL(Leftlist, Rightlist);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        return mergeKLists(lists, 0, lists.length - 1);
    }

    private static void addFirstNode(ListNode node) {
        if (th == null) {
            th = tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }

    public static int length(ListNode head) {
        if (head == null)
            return 0;
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        return len;
    }

    public static ListNode th = null, tt = null;

    public static ListNode reverseInKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1)
            return head;

        int len = length(head);
        ListNode curr = head, oh = null, ot = null;
        while (len >= k) {
            int tempk = k;
            while (tempk-- > 0) {
                ListNode forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr = forw;
            }

            if (oh == null) {
                oh = th;
                ot = tt;
            } else {
                ot.next = th;
                ot = tt;
            }

            th = tt = null;
            len -= k;
        }
        ot.next = curr;
        return oh;
    }

    // O(m)
    public static ListNode reverseInRange(ListNode head,int n,int m){
        if(head == null || head.next == null || n == m) 
            return head;
        
        ListNode dummy = new ListNode(-1), prev = dummy,curr = head;
        int i = 1;
        while(i <= m){
            while(i >= n && i <= m){
                ListNode forw = curr.next;
                curr.next  = null;
                addFirstNode(curr);
                curr = forw;
                i++;
            }

            if(i > m){
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
}