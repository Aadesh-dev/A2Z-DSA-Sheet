/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node child;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.child = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.child = null;
     }
     Node(int data, Node next, Node child)
     {
         this.data = data;
         this.next = next;
         this.child = child;
     }
 }

 *****************************************************************/

public class Solution {
    public static Node flattenLinkedList(Node head) {
        if(head.next == null) {
            return head;
        }
        Node merged = flattenLinkedList(head.next);
        return merge(head, merged);
    }

    public static Node merge(Node l1, Node l2) {
        Node start = new Node(), p = start;
        while(l1 != null && l2 != null) { 
            if(l1.data < l2.data) {
                p.child = l1;
                l1 = l1.child;
            } else {
                p.child = l2;
                l2 = l2.child;
            }
            p = p.child;
        }
        if(l1 != null) {
            p.child = l1;
        }
        if(l2 != null) {
            p.child = l2;
        }
        return start.child;
    }
}
//Time: O(n) where n is the total number of nodes, Space: O(1)