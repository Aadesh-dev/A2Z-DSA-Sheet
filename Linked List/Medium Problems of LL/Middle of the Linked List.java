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
    public ListNode middleNode(ListNode head) {
        int len = 0, index = -1;
        ListNode curr = head;
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        while(index < len / 2) {
            index++;
            if(index == 0) {
                curr = head;
            } else {
                curr = curr.next;
            }
        }
        return curr;
    }
}
//Time: O(n), Space: O(1)
//Use 0 based indexing when 2nd is the answer for even length LLs. while(index < len / 2)
//Use 1 based indexing when 1st is the answer for odd length LLs. while(index < Math.ceil(len / 2.0))


class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
//Time: O(n), Space: O(1)