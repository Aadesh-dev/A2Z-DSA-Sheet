/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode curr = head;
        while(curr != null && curr.next != null) {
            if(curr == curr.next) return curr;
            ListNode curr2 = head;
            while(curr2 != curr) {
                if(curr2 == curr.next) return curr2;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        return null;
    }
}
//Time: O(n^2), Space: O(1)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode curr = head, fast = head, slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null) return null;
        while(curr != slow) {
            curr = curr.next;
            slow = slow.next;
        }
        return curr;
    }
}
//Time: O(n), Space: O(1)

// slow moves 1 step at a time, fast moves 2 steps at a time.
// when slow and fast meet each other, they must be on the cycle
// x denotes the distance from the start of the linked list to the start of the cycle
// y denotes the distance from the start of the cycle to where slow and fast met
// C denotes the length of the cycle
// when they meet, slow traveled (x + y) steps while fast traveled 2 * (x + y) steps, and the extra distance (x + y) must be a multiple of the circle length C
// note that x, y, C are all lengths or the number of steps need to move.
// head, slow, fast are pointers.
// head moves x steps and arrives at the start of the cycle.
// so we have x + y = N * C, let slow continue to travel from y and after x more steps, slow will return to the start of the cycle.
// At the same time, according to the definition of x, head will also reach the start of the cycle after moving x steps.
// so if head and slow start to move at the same time, they will meet at the start of the cycle, that is the answer.
//https://www.youtube.com/watch?v=QfbOhn0WZ88&t=851s&ab_channel=takeUforward
//https://www.youtube.com/watch?v=-YiQZi3mLq0&ab_channel=GauravSen