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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while(curr != null) {
            if(set.contains(curr)) {
                return true;
            }
            set.add(curr);
            curr = curr.next;
        }
        return false;
    }
}
//Time: O(n), Space: O(n)

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode curr = head;
        while(curr != null && curr.next != null) {
            if(curr == curr.next) return true;
            ListNode curr2 = head;
            while(curr2 != curr) {
                if(curr2 == curr.next) return true;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        return false;
    }
}
//Time: O(n^2), Space: O(1)

public class Solution {

    public static boolean detectCycle(Node head) {
        Node walker = head;
        Node runner = head;
        while(runner!=null && runner.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) return true;
        }
        return false;
    }
}
//Time: O(n), Space: O(1)
// Walker goes 1 step at a time,and runner goes 2 steps at a time.
// If we think walker is still,then runner goes 1 step at a time.
// So,the problem is just like a Chasing problem.
// There is a time when runner catches walker.

// In Captain America :The Winter Soldier, Steve Rogers(captain ) was your runner while, Sam Wilson (falcon) was walker. Now since, both of them were circling around Lincoln Memorial, Steve always caught Sam at some point and told him "On your left" . If they were moving linearly with the same speed, both of them would have never met each other in any point of time.
//Conclusion: If two points are moving circularly with different velocities, then they will always meet at some point in time.