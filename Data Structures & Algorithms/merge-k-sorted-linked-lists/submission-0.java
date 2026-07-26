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

// Merge K Sorted Linked Lists
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return mergeListsHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeListsHelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        if (start + 1 == end) {
            return mergeTwoLists(lists[start], lists[end]);
        }

        int middle = start + (end - start) / 2;
        ListNode left = mergeListsHelper(lists, start, middle);
        ListNode right = mergeListsHelper(lists, middle + 1, end);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return dummy.next;
    }
}
