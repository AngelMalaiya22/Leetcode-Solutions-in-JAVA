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
    public ListNode rotateRight(ListNode head, int k) {
        // Base edge cases: empty list, single node, or no rotation
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Compute length and find tail
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Compute effective rotations
        int effectiveK = k % length;
        if (effectiveK == 0) {
            return head; // Rotation returns list to original state
        }

        // Step 3: Connect tail to head to form a circular list
        tail.next = head;

        // Step 4: Find the new tail at position (length - effectiveK - 1)
        int stepsToNewTail = length - effectiveK - 1;
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Step 5: Set new head and break the ring
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}