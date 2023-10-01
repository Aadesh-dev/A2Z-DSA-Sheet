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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int len = 0;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            len += 2;
        }
        if(fast != null) len++;
        k = k % len;
        if(len == k) return head;
        int count = 1;
        ListNode curr = head, prev = null, newHead = null;
        while(count <= len - k) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        newHead = prev;
        prev = null;
        while(count <= len) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        head.next = prev;
        curr = newHead;
        prev = null;
        count = 1;
        while(count <= len) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        return prev;
    }
}

//Time: O(3n) => O(n), Space: O(1)

public static ListNode rotateRight(ListNode head, int k) {
	if(head==null || head.next == null || k == 0) return head;
	int size = 1; // since we are already at head node
	ListNode fast=head;
	ListNode slow = head;
	
	while(fast.next!=null){
	    size++;
	    fast = fast.next;
	}
	
	for(int i=size-k%size;i>1;i--) // i>1 because we need to put slow.next at the start.
		slow = slow.next;
	
    // No dummy variable.
	fast.next = head;
	head = slow.next;
	slow.next = null;
	
	return head;
}
//Time: O(n + (n-k)) => O(n), Space: O(1)