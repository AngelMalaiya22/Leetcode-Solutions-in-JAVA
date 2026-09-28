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
 /*
class Solution 
{
    public ListNode middleNode(ListNode head) 
    {
        int middle=0;
        ListNode temp= head;
        int len= length(ListNode head);
        if(len%2!=0)
        {
            middle= len%2;
            while(middle>0)
            {

            }
        }
    }

    int length(ListNode head)
    {
        ListNode temp= head;
        int l=0;
        while(temp!= NULL)
        {
            l++;
            temp=temp.next;
        }
        return l;
    }
}
*/
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}