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

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
         this.prev = next;
     }
 };

 *****************************************************************/

public class Solution
{
    public static Node reverseDLL(Node head)
    {
        Node reversedHead = new Node();
        Node reversedNode = reversedHead;
        Node node = head;
        while(node.next != null) node = node.next;
        reversedNode.data = node.data;
        node = node.prev;
        while(node != null) {
            Node temp = new Node();
            temp.data = node.data;
            reversedNode.next = temp;
            temp.prev = reversedNode;
            reversedNode = temp;
            node = node.prev;
        }
        return reversedHead;
    }
}
//Time: O(n), Space: O(n)

//Optimal:
public class Solution
{
    public static Node reverseDLL(Node head)
    {
        if(head.next == null)
        {
            return head;
        }

        Node curr = head;
        Node temp = null;

        // Traverse the linked list to the end
        while (curr != null)
        {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        head = temp.prev;

        // New head of the modified list is returned
        return head;
    }
}
//Time: O(n), Space: O(1)

