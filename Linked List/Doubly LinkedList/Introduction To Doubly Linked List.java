/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node prev;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }

     Node(int data, Node next, Node prev)
     {
         this.data = data;
         this.next = next;
         this.prev = prev;
     }
 };

 *****************************************************************/

public class Solution
{
    public static Node constructDLL(int []arr) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1; i<arr.length; i++) {
            Node node = new Node(arr[i]);
            prev.next = node;
            node.prev = prev;
            prev = node;
        }
        return head;
    }
}
//Time: O(n), Space: O(1)