/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Dummy node handles edge cases where left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Reach the node just BEFORE position 'left'
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // 'curr' will be the head of our sublist that gets pushed forward
        ListNode curr = prev.next;

        // Step 2: Reverse the sublist by moving 'next' nodes to 'prev.next'
        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}