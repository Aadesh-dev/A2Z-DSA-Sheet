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
        ListNode node = new ListNode();
        ListNode l1 = list1, l2 = list2, head = node;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        
        while(l1 != null) {
            node.next = l1;
            l1 = l1.next;
            node = node.next;
        }

        while(l2 != null) {
            node.next = l2;
            l2 = l2.next;
            node = node.next;
        }

        return head.next;
    }
}
//Time: O(m + n), Space: O(1)