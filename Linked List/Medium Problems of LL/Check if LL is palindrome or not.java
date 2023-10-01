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
    public boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        int len = 0;
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        int arr[] = new int[len / 2];
        int i = 0;
        curr = head;
        while(i < len / 2) {
            arr[i++] = curr.val;
            curr = curr.next;
        }
        i = (len / 2) - 1;
        if(len % 2 != 0) curr = curr.next;
        while(i >= 0 && curr != null) {
            if(arr[i] != curr.val) return false;
            i--;
            curr = curr.next;
        }
        return true;
    }
}
//Time: O(n), Space: O(n)

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev = null, next = null;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow != null) {
            next = slow.next;
            slow.next = prev; 
            prev = slow;
            slow = next;
        }
        slow = head;
        while(prev != null) {
            if(slow.val != prev.val) return false;
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }
}
//Time: O(n), Space: O(1)
//1. Go till half of the LL
//2. Reverse the right half
//3. Compare the left half with the reversed right half. If both are equal then the LL is a palindrome
//4. (Optional) Since we are solving this in place, we are modifiying the input LL. Hence, we can reverse the right half back.

