
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        int count = 0;

        // Check if k nodes are available
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        if (count < k)
            return head;

        // Reverse k nodes
        ListNode prev = null;
        ListNode curr = head;

        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Connect remaining list
        head.next = reverseKGroup(curr, k);

        return prev;
    }
}
