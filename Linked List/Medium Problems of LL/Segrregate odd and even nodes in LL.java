//Leetcode
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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        int count = 1;
        ListNode oddPrev = null, evenPrev = null, evenHead = null, curr = head;
        while(curr != null) {
            if(count % 2 != 0) {
                if(oddPrev != null) oddPrev.next = curr;
                oddPrev = curr;
            } else {
                if(count == 2) evenHead = curr;
                if(evenPrev != null) evenPrev.next = curr;
                evenPrev = curr;
            }
            curr = curr.next;
            count++;
        }
        //To avoid cycle
        if(evenPrev != null) evenPrev.next = null;
        oddPrev.next = evenHead;
        return head;
    }
}
//Time: O(n), Space: O(1)

//Smarter
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        // `even != null` rules out the list of only 1 node
        // `even.next != null` rules out the list of only 2 nodes
        while (even != null && even.next != null) {
            // Put odd to the odd list
            odd.next = odd.next.next;
            
            // Put even to the even list
            even.next = even.next.next;
            
            // Move the pointer to the next odd/even
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
//Time: O(n), Space: O(1)

//Codingninjas
/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }

 *****************************************************************/

public class Solution
{
    public static Node segregateEvenOdd(Node head)
    {
        Node oddPrev = null, evenPrev = null, oddHead = null, evenHead = null, curr = head;
        while(curr != null) {
            if(curr.data % 2 != 0) {
                if(oddPrev != null) 
                {
                    oddPrev.next = curr;
                } else {
                    oddHead = curr;
                }
                oddPrev = curr;
            } else {
                if(evenPrev != null) {
                    evenPrev.next = curr;
                } else {
                    evenHead = curr;
                }
                evenPrev = curr;
            }
            curr = curr.next;
        }
        if(evenPrev != null) evenPrev.next = null;
        if(oddPrev != null) oddPrev.next = null;
        evenPrev.next = oddHead;
        return evenHead;
    }
}
//Time: O(n), Space: O(1)