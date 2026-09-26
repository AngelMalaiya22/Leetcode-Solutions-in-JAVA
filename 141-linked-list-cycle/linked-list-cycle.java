public class Solution {
    public boolean hasCycle(ListNode root) {
        if (root == null || root.next == null) {
            return false;
        }

        ListNode slow = root;
        ListNode fast = root;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move 1 step
            fast = fast.next.next;     // Move 2 steps

            // If fast and slow pointers meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        return false; // Fast reached the end, no cycle
    }
}