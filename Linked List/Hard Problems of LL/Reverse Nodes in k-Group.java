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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        ListNode dummy = new ListNode(0), pre = dummy, curr = dummy, next = dummy, fast = head;
        dummy.next = head;
        int count = 1;
        while(fast != null && fast.next != null ) {
            fast = fast.next.next;
            count += 2;
        }
        if(fast == null) count--;

        while(count >= k) {
            curr = pre.next;
            next = curr.next;
            for(int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = curr.next;
            }
            pre = curr;
            count -= k;
        }
        
        return dummy.next;
    }
}
//Time: O((n / k) * k) => O(n), Space: O(1)
//https://www.youtube.com/watch?v=Of0HPkk3JgI&ab_channel=takeUforward

//Another good solution and more intuitive:
//https://leetcode.com/problems/reverse-nodes-in-k-group/solutions/11440/non-recursive-java-solution-and-idea/