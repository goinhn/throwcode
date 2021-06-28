public class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        int interval = 1;

        while (interval < length) {
            for (int i = 0; i < length - interval; i += interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + 1]);
            }
            interval *= 2;
        }

        if (length > 0) {
            return lists[0];
        } else {
            return null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode middle = result;

        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }

        if (l1 != null) {
            result.next = l1;
        }

        if (l2 != null) {
            result.next = l2;
        }

        return middle.next;
    }

}



class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
