/****************************************************************

 Following is the class structure of the Node class:

 static class Node
 {
     int data;
     Node next;
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
//Inserting at the end of the linked list
public class Solution {
    static class Stack {
        Node head, node;
        int count;

        Stack()
        {
            count = 0;
        }

        int getSize()
        {
            return count;
        }

        boolean isEmpty()
        {
            return count == 0;
        }

        void push(int data)
        {
            if(node != null) {
                node.next = new Node(data);
                node = node.next;
            } else {
                node = new Node(data);
            }
            if(count == 0) head = node;
            count++;
        }

        void pop()
        {
            if(count > 1) {
                Node temp = head;
                while(temp.next != node) {
                    temp = temp.next;
                }
                temp.next = null;
                node = temp;
                count--;
            } else if(count == 1) {
                head = null;
                node = null;
                count--;
            }
        }

        int getTop()
        {
            return count > 0 ? node.data : -1;
        }
    }
}
//Time: O(n) for pop, Space: O(1)

//Inserting at the beginning of the linked list
public class Solution {
    static class Stack {
        Node head;
        int count;

        Stack()
        {
            count = 0;
        }

        int getSize()
        {
            return count;
        }

        boolean isEmpty()
        {
            return count == 0;
        }

        void push(int data)
        {
            Node node = new Node(data);
            node.next = head;
            head = node;
            count++;
        }

        void pop()
        {
            if(count > 0) {
                head = head.next;
                count--;
            }
        }

        int getTop()
        {
            return count > 0 ? head.data : -1;
        }
    }
}
//Time: O(1) for pop, Space: O(1)