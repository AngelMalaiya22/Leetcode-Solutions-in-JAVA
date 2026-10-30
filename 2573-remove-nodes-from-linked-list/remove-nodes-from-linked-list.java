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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        
        // Push all nodes into the stack
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        
        // Traverse back from the tail using the stack
        ListNode resultHead = stack.pop();
        int maxVal = resultHead.val;
        
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            // If current node's value is less than max seen so far, skip it
            if (node.val < maxVal) {
                continue;
            } else {
                // Otherwise, keep it in the list
                node.next = resultHead;
                resultHead = node;
                maxVal = node.val;
            }
        }
        
        return resultHead;
    }
}