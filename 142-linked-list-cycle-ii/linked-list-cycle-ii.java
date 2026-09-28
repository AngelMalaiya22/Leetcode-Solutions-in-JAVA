public class Solution {
    public ListNode detectCycle(ListNode root) {
        if (root == null || root.next == null) {
            return null;
        }

        ListNode slow = root;
        ListNode fast = root;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode reassign = root;
                while (reassign != slow) {
                    reassign = reassign.next;
                    slow = slow.next;
                }
                return reassign;
            }
        }
        
        return null;
    }
}