
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        while (lists.length > 1) {
            ListNode[] temp = new ListNode[(lists.length + 1) / 2];

            for (int i = 0; i < lists.length / 2; i++) {
                temp[i] = merge(lists[2 * i], lists[2 * i + 1]);
            }

            if (lists.length % 2 == 1) {
                temp[temp.length - 1] = lists[lists.length - 1];
            }

            lists = temp;
        }

        return lists[0];
    }

    ListNode merge(ListNode a, ListNode b) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (a != null && b != null) {

            if (a.val <= b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }

            curr = curr.next;
        }

        if (a != null)
            curr.next = a;

        if (b != null)
            curr.next = b;

        return dummy.next;
    }
}
