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

// Reorder Linked List
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;

        // Reverse the second half of the Linked List
        ListNode reversedTail = middle.next;
        while (reversedTail.next != null) {
            ListNode nodeToMove = reversedTail.next;
            reversedTail.next = nodeToMove.next;
            nodeToMove.next = middle.next;
            middle.next = nodeToMove;
        }

        // Reordered Linked List
        ListNode firstHalfNode = head;
        ListNode secondHalfNode = middle.next;
        while (firstHalfNode != middle) {
            middle.next = secondHalfNode.next;
            secondHalfNode.next = firstHalfNode.next;
            firstHalfNode.next = secondHalfNode;
            firstHalfNode = secondHalfNode.next;
            secondHalfNode = middle.next;
        }
    }
}
