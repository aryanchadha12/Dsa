
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Find the meeting point
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                // Find starting point of cycle
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}
