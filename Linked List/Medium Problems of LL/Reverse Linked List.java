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
//Iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, next = null, prev = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
//Time: O(n), Space: O(1)
//Steps
//1. Store the next node in next
//2. Assign the next pointer to prev
//3. The current node becomes prev to use in the next iteration
//4. Move curr to next node by using next as next stores the next node

//Recursive
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        return recursiveReverseList(curr, null);
    }

    public static ListNode recursiveReverseList(ListNode curr, ListNode prev) {
        if(curr == null) return prev;
        ListNode next = curr.next;
        curr.next = prev;
        return recursiveReverseList(next, curr);
    }
}
//Time: O(n), Space: O(n)