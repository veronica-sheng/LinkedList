/*
143
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
12/10/2018 17:01 - 17:32
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode half = slow.next;
        while(half != null){
            stack.push(half);
            half = half.next;
        }
        slow.next = null;
        ListNode cur = head;
        while(!stack.isEmpty() && cur != null){
            ListNode next = cur.next;
            cur.next = stack.pop();
            cur.next.next = next;
            cur = next;
            
        }
    }
}