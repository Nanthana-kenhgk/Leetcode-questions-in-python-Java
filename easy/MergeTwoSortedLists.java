// Problem: 21. Merge Two Sorted Lists
// Topic: Linked List
// Iteratively merge two sorted linked lists by comparing node values and reusing existing nodes.
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode i = list1;
        ListNode j = list2;
        if(i==null ^ j==null){
            return i==null? j:i;
        }
        else if(i==null && j==null){
            return null;
        }
        ListNode current = i.val<=j.val? i:j ;
        ListNode head = current;
        if(i.val<=j.val){
            i = current.next;
        }
        else{
            j = current.next;
        }
        while(i!=null && j!=null){
            ListNode nextNode = i.val<=j.val? i:j ;
            current.next = nextNode;
            current = nextNode;
            if(i.val<=j.val){
                i = nextNode.next;
            }
            else{
                j = nextNode.next;
            }
        }
        ListNode remaining = i!=null ? i:j;
        current.next = remaining;
        return head;
    }
}
