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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        ListNode curr = head;
        int size = 0;
        while(curr != null) {
            curr = curr.next;
            size++;
        }
        if(size == n) return head.next;
        int pos = 1;
        curr = head;
        while(pos < size - n) {
            curr = curr.next;
            pos++;
        }
        curr.next = curr.next.next;
        return head;
    }
}
//Time: O(2n) => O(n), Space: O(1)

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        start.next = head;
        
        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}
//Time: O(n), Space: O(1)

