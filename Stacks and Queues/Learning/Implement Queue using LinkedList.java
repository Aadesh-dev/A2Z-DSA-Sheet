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

 class Queue{
     Node front;
     Node rear;
     void push(){};
     Queue() {
         front = null;
         rear = null;
     }
 }

 *****************************************************************/

public class Solution extends Queue{
    public void push(int x) {
        Node node = new Node(x);
        if(rear != null) rear.next = node;
        rear = node;
        if(front == null) front = node;
    }

    public int pop() {
        if(front == null) return -1;
        int data = front.data;
        front = front.next;
        return data;
        
    }
}
//Time: O(1), Space: O(1)