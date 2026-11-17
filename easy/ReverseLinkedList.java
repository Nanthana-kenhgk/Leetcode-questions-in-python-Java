// Problem: 206. Reverse Linked List
// Topic: Linked List
// We use a prev pointer to iteratively reverse the linked list by changing each node's next pointer using prev, current, and temp references.
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
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode temp = null;
        while(current!=null){
            temp = prev;
            prev = current;
            current = current.next;
            prev.next = temp;
        }
        return prev;
    }
}
