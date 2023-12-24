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
    public ListNode mergeKLists(ListNode[] lists) {
       ListNode node = new ListNode();
       ListNode head = node;
       PriorityQueue<ListNode> heap = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
       for(ListNode list : lists) {
           if(list != null) heap.add(list);
       }
       while(!heap.isEmpty()) {
           ListNode min = heap.poll();
           node.next = min;
           node = node.next;
           if(min.next != null) heap.add(min.next);
       }
        return head.next;
    }
}
//Time: O(n * 2 * logk) => O(n logk), Space: O(k)
//where k = number of lists, n = number of nodes
//https://www.youtube.com/watch?v=ptYUCjfNhJY&ab_channel=BackToBackSWE