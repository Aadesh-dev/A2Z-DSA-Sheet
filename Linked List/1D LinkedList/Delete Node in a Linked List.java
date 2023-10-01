/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        while(node.next != null) {
            node.val = node.next.val;
            if(node.next.next == null) {
                node.next = null;
            } else {
                node = node.next;
            }
        }
    }
}
//Time: O(n), Space: O(1)

//Optimal:
class Solution {
    public void deleteNode(ListNode node) {
        // Since we know input node is not last node, so nextNode will not be null
        ListNode nextNode = node.next;
        // Step 2
        node.val = nextNode.val;
        // Step 3
        node.next = nextNode.next;
        //Don't need below line, but kept for clarity
        nextNode.next = null;
    }
}
//Time: O(1), Space: O(1)

//CodingNinjas:
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
 };

 *****************************************************************/

public class Solution {
    public static Node deleteLast(Node list){
        if(list.next == null) return null;
        Node node = list;
        while(node.next.next != null) {
            node = node.next;
        }
        node.next = null;
        return list;
    }
}
//Time: O(n), Space: O(1)