public class Solution {
    public boolean hasCycle(ListNode root) {
        if (root == null || root.next == null) {
            return false;
        }

        ListNode slow = root;
        ListNode fast = root;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}