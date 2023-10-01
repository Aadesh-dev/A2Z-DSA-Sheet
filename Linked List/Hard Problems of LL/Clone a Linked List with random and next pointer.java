/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node original = head;
        Node newHead = new Node(0), newNode = newHead;
        while(original != null) {
            Node tempNode = new Node(original.val);
            newNode.next = tempNode;
            newNode = tempNode;
            original = original.next;
        }
        original = head;
        newNode = newHead.next;
        while(original != null) {
            Node randomFromOriginal = original.random, temp = head, temp2 = newHead.next;
            if(randomFromOriginal != null) {
                while(temp != null) {
                    if(temp == randomFromOriginal) break;
                    temp = temp.next;
                    temp2 = temp2.next;
                }
                newNode.random = temp2;
            }
            original = original.next;
            newNode = newNode.next;
        }
        return newHead.next;
    }
}
Time: O(n^2), Space: O(1)

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node original = head;
        //Step 1
        while(original != null) {
            Node tempNode = new Node(original.val);
            tempNode.next = original.next;
            original.next = tempNode;
            original = original.next.next;
        }
        original = head;
        //Step 2
        while(original != null) {
            if(original.random != null) {
                original.next.random = original.random.next;
            }
            original = original.next.next;
        }
        original = head;
        Node newHead = new Node(0), newNode = head.next;
        newHead.next = head.next;
        //Step 3
        while(original != null) {
            original.next = original.next.next;
            newNode.next = newNode.next != null ? newNode.next.next : null;
            original = original.next;
            newNode = newNode.next;
        }
        return newHead.next;
    }
}
Time: O(3n) => O(n), Space: O(1)
//Step 1: For the list 7 -> 13 -> 11 -> 10 -> 1 -> null, create the list:
//7 -> 7(deep copy) -> 13 -> 13(deep copy) -> 11 -> 11(deep copy) -> 10 -> 10(deep copy) -> 1 -> 1(deep copy) -> null

//Step 2: Assign each node's next's random to that node's random's next.
//eg. if 11's random is 1, then 11(deep copy)'s random is 1's next which is 1(deep copy). 

//Step 3: Reconstruct the original list and also the deep copy list by changing the next pointers.
//Return the head of the new list stored in a variable before starting step 3.